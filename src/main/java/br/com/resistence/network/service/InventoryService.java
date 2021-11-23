package br.com.resistence.network.service;

import br.com.resistence.network.controller.request.InventoryTradeRequest;
import br.com.resistence.network.entity.Inventory;
import br.com.resistence.network.exception.InvalidTradeException;
import br.com.resistence.network.exception.InventoryNotFoundException;
import br.com.resistence.network.model.InventoryType;
import br.com.resistence.network.model.Operation;
import br.com.resistence.network.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void doTrade(List<Inventory> inventoryFrom, List<Inventory> inventoryTo) {
        repository.saveAll(inventoryFrom);
        repository.saveAll(inventoryTo);
    }

    public List<Inventory> prepareInventory(InventoryTradeRequest.Trades trade, Operation operation) throws InventoryNotFoundException, InvalidTradeException {

        Map<InventoryType, Inventory> inventory = repository.findAllByRebelId(trade.getRebelId())
                .stream().collect(Collectors.toMap(Inventory::getInventoryType, Function.identity()));

        List<Inventory> itemsToTrade = new ArrayList<>();

        for (InventoryTradeRequest.Item item : trade.getItems()) {

            if (!inventory.containsKey(item.getInventoryType())) {
                throw new InventoryNotFoundException();
            }

            Inventory inv = inventory.get(item.getInventoryType());

            if (inv.getQuantity() < item.getQuantity() && operation.equals(Operation.FROM)) {
                throw new InvalidTradeException("Erro! O rebelde quer trocar mais itens do que possui!");
            }else{
                inv.setQuantity(inv.getQuantity() - item.getQuantity());
            }

            if (inv.getQuantity() > item.getQuantity() && operation.equals(Operation.TO)) {
                throw new InvalidTradeException("Erro! O rebelde quer trocar mais itens do que o outro rebelde possui!");
            }else{
                inv.setQuantity(inv.getQuantity() + item.getQuantity());
            }

            itemsToTrade.add(inv);
        }

        return itemsToTrade;
    }

    public void validateTrade(InventoryTradeRequest request) throws InvalidTradeException {

        int sumFromPoints = request.getFrom().getItems().stream()
                .map(item -> item.getInventoryType().getPoints() * item.getQuantity())
                .collect(Collectors.summingInt(Integer::intValue));

        int sumToPoints = request.getTo().getItems().stream()
                .map(item -> item.getInventoryType().getPoints() * item.getQuantity())
                .collect(Collectors.summingInt(Integer::intValue));

        if (sumFromPoints != sumToPoints) {
            throw new InvalidTradeException();
        }

    }

}
