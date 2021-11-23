package br.com.resistence.network.controller.request;

import br.com.resistence.network.model.InventoryType;

import javax.validation.constraints.NotNull;

public class InventoryRequest {

    private Long id;
    @NotNull
    private InventoryType inventoryType;
    @NotNull
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
