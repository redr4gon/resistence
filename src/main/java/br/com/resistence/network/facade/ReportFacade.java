package br.com.resistence.network.facade;

import br.com.resistence.network.controller.response.ReportInventoryResponse;
import br.com.resistence.network.controller.response.ReportMessageResponse;
import br.com.resistence.network.entity.Rebel;
import br.com.resistence.network.model.InventoryType;
import br.com.resistence.network.service.RebelService;
import br.com.resistence.network.utils.NumberUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ReportFacade {

    private final RebelService rebelService;

    public ReportFacade(RebelService rebelService) {
        this.rebelService = rebelService;
    }

    public ReportMessageResponse totalRebelBlackForce() {
        List<Rebel> rebelsBlackForce = rebelService.findAllBlackForce();
        List<Rebel> rebels = rebelService.findAll();

        ReportMessageResponse response = new ReportMessageResponse();
        response.setKey("Total de traidores (% arredondado)");
        response.setValue(NumberUtil.toPercentage(rebelsBlackForce.size(), rebels.size()) + "%");

        return response;
    }

    public ReportMessageResponse totalRebel() {
        List<Rebel> rebelsBlackForce = rebelService.findAllBlackForce();
        List<Rebel> rebels = rebelService.findAll();

        ReportMessageResponse response = new ReportMessageResponse();
        response.setKey("Total de rebeldes (% arredondado)");
        response.setValue(BigDecimal.valueOf(100).subtract(NumberUtil.toPercentage(rebelsBlackForce.size(), rebels.size())) + "%");

        return response;
    }

    public ReportInventoryResponse totalInventory() {
        List<Rebel> rebels = rebelService.findAllNotBlackForce();
        Map<InventoryType, Integer> map = new HashMap<>();

        ReportInventoryResponse response = new ReportInventoryResponse();

        rebels.forEach(rebel ->
            rebel.getInventories().forEach(inventory -> {
                if (map.containsKey(inventory.getInventoryType())) {
                    map.put(inventory.getInventoryType(), map.get(inventory.getInventoryType()) + inventory.getQuantity());
                }else{
                    map.put(inventory.getInventoryType(), inventory.getQuantity());
                }
            })
        );

        map.entrySet().stream().forEach(entry ->
            response.addInventoryResponse(entry.getKey(), entry.getValue() / rebels.size())
        );

        return response;
    }

    public ReportMessageResponse totalRebelBlackForcePoints() {
        List<Rebel> rebels = rebelService.findAllBlackForce();

        int totalPoints = rebels.stream().flatMap(rebel ->
            rebel.getInventories().stream().map(inventory -> inventory.totalPoints())
        ).collect(Collectors.summingInt(Integer::intValue));

        ReportMessageResponse response = new ReportMessageResponse();
        response.setKey("Pontos perdidos devido a traição (somatório do valor dos itens perdidos)");
        response.setValue(String.valueOf(totalPoints));

        return response;
    }
}
