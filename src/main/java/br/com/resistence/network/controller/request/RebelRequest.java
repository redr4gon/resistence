package br.com.resistence.network.controller.request;

import br.com.resistence.network.model.Genre;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RebelRequest {

    @NotEmpty(message = "O nome não pode ser vazio!")
    private String name;
    @NotNull(message = "A idade não pode ser vazia!")
    private Integer age;
    @NotNull(message = "O gênero não pode ser vazio!")
    private Genre genre;
    @Valid
    @NotNull(message = "A localização não pode ser vazia!")
    private LocalizationRequest localization;
    @Valid
    private List<InventoryRequest> inventories;
    private Integer blackForceReport;

    public RebelRequest() {
        this.blackForceReport = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalizationRequest getLocalization() {
        return localization;
    }

    public void setLocalization(LocalizationRequest localization) {
        this.localization = localization;
    }

    public List<InventoryRequest> getInventories() {
        return inventories;
    }

    public void setInventories(List<InventoryRequest> inventories) {
        this.inventories = inventories;
    }

    public Integer getBlackForceReport() {
        return blackForceReport;
    }

    public void setBlackForceReport(Integer blackForceReport) {
        this.blackForceReport = blackForceReport;
    }
}
