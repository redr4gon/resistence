package br.com.resistence.network.controller.request;

import javax.validation.constraints.NotEmpty;

public class LocalizationRequest {

    @NotEmpty(message = "O nome da galáxia pode ser vazio!")
    private String galaxyName;
    @NotEmpty(message = "A latitude não pode ser vazia!")
    private String latitude;
    @NotEmpty(message = "A longitude não pode ser vazia!")
    private String longitude;

    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
