package br.com.resistence.network.controller.response;

import br.com.resistence.network.model.InventoryType;

import java.util.ArrayList;
import java.util.List;

public class ReportInventoryResponse {

    private String title;
    private List<InventoryResponse> responses;

    public ReportInventoryResponse() {
        this.title = "Média de itens sendo usados pelos rebeldes para cada tipo de item";
    }

    public static class InventoryResponse {

        private InventoryType type;
        private Integer average;

        public InventoryType getType() {
            return type;
        }

        public void setType(InventoryType type) {
            this.type = type;
        }

        public Integer getAverage() {
            return average;
        }

        public void setAverage(Integer average) {
            this.average = average;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<InventoryResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<InventoryResponse> responses) {
        this.responses = responses;
    }

    public void addInventoryResponse(InventoryType type, Integer value) {
        InventoryResponse response = new InventoryResponse();
        response.setAverage(value);
        response.setType(type);

        if (this.responses == null) {
            this.responses = new ArrayList<>();
        }

        this.responses.add(response);
    }
}
