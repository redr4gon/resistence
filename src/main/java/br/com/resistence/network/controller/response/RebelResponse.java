package br.com.resistence.network.controller.response;

import br.com.resistence.network.entity.Inventory;
import br.com.resistence.network.entity.Localization;
import br.com.resistence.network.model.Genre;

import java.util.List;

public class RebelResponse {

    private Long id;
    private String name;
    private Integer age;
    private Genre genre;
    private Localization localization;
    private List<Inventory> inventories;
    private Integer blackForceReport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Integer getBlackForceReport() {
        return blackForceReport;
    }

    public void setBlackForceReport(Integer blackForceReport) {
        this.blackForceReport = blackForceReport;
    }
}
