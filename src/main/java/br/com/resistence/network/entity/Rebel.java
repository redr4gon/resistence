package br.com.resistence.network.entity;

import br.com.resistence.network.model.Genre;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Rebel {

    @Id
    @GeneratedValue(generator = "rebel_seq")
    private Long id;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @OneToOne(cascade = CascadeType.ALL)
    private Localization localization;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Inventory> inventories;
    private Integer blackForceReport;

    public Rebel() {
        this.blackForceReport = 0;
    }

    public Integer getBlackForceReport() {
        return blackForceReport;
    }

    public void setBlackForceReport(Integer blackForceReport) {
        this.blackForceReport = blackForceReport;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

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

    @Transient
    public void reportBlackForce() {
        if (blackForceReport == null) {
            blackForceReport = 0;
        }
        this.blackForceReport++;
    }

}