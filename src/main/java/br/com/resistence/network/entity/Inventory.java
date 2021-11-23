package br.com.resistence.network.entity;

import br.com.resistence.network.model.InventoryType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(generator = "inventory_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    private InventoryType inventoryType;
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

    @Transient
    public Integer totalPoints() {
        return this.inventoryType.getPoints() * this.quantity;
    }
}
