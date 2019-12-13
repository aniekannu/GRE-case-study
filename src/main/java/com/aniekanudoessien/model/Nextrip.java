package com.aniekanudoessien.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Nextrip {

    @JsonProperty(value = "DepartureText")
    private String departureText;

    public Nextrip() {
    }

    public Nextrip(String departureText) {
        this.departureText = departureText;
    }

    public String getDepartureText() {
        return departureText;
    }

    public void setDepartureText(String departureText) {
        this.departureText = departureText;
    }

    @Override
    public String toString() {
        return "Nextrip{" +
                "departureText='" + departureText + '\'' +
                '}';
    }
}
