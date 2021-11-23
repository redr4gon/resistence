package br.com.resistence.network.facade;

import br.com.resistence.network.controller.request.InventoryTradeRequest;
import br.com.resistence.network.entity.Inventory;
import br.com.resistence.network.entity.Rebel;
import br.com.resistence.network.exception.InvalidTradeException;
import br.com.resistence.network.exception.InventoryNotFoundException;
import br.com.resistence.network.exception.RebelNotFoundException;
import br.com.resistence.network.model.Operation;
import br.com.resistence.network.service.InventoryService;
import br.com.resistence.network.service.RebelService;
import br.com.resistence.network.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryFacade {

    private final InventoryService inventoryService;
    private final RebelService rebelService;

    public InventoryFacade(InventoryService inventoryService, RebelService rebelService) {
        this.inventoryService = inventoryService;
        this.rebelService = rebelService;
    }

    public void tradeItems(InventoryTradeRequest request) throws InvalidTradeException, InventoryNotFoundException, RebelNotFoundException {

        inventoryService.validateTrade(request);
        validateRebel(request);

        List<Inventory> inventoryFrom = inventoryService.prepareInventory(request.getFrom(), Operation.FROM);
        List<Inventory> inventoryTo = inventoryService.prepareInventory(request.getTo(), Operation.TO);

        inventoryService.doTrade(inventoryFrom, inventoryTo);
    }

    private void validateRebel(InventoryTradeRequest request) throws RebelNotFoundException, InvalidTradeException {

        Rebel rebelFrom = rebelService.findOne(request.getFrom().getRebelId());
        Rebel rebelTo = rebelService.findOne(request.getFrom().getRebelId());

        if (rebelFrom == null || rebelFrom.getBlackForceReport() >= Constants.BLACK_FORCE_POINTS) {
            throw new InvalidTradeException("Rebeldes do lado negro não podem fazer trocas!");
        }

        if (rebelTo == null || rebelTo.getBlackForceReport() >= Constants.BLACK_FORCE_POINTS) {
            throw new InvalidTradeException("Rebeldes do lado negro não podem fazer trocas!");
        }
    }

}
