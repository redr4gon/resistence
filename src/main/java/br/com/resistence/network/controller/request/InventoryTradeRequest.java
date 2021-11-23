package br.com.resistence.network.controller.request;

import br.com.resistence.network.model.InventoryType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class InventoryTradeRequest {

    @Valid
    @NotNull(message = "A origem da troca não pode ser vazia!")
    private Trades from;

    @Valid
    @NotNull(message = "O destino da troca não pode ser vazio!")
    private Trades to;

    public static class Trades {

        @NotNull(message = "O id do rebelde não pode ser vazio!")
        private Long rebelId;

        @Valid
        @NotNull(message = "Os items são obrigatórios para a troca!")
        private List<Item> items;

        public Long getRebelId() {
            return rebelId;
        }

        public void setRebelId(Long rebelId) {
            this.rebelId = rebelId;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    public static class Item {

        @NotNull(message = "O tipo de inventário não pode ser vazio!")
        private InventoryType inventoryType;
        @NotNull(message = "A quantidade não pode ser vazia!")
        private Integer quantity;

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

    public Trades getFrom() {
        return from;
    }

    public void setFrom(Trades from) {
        this.from = from;
    }

    public Trades getTo() {
        return to;
    }

    public void setTo(Trades to) {
        this.to = to;
    }
}
