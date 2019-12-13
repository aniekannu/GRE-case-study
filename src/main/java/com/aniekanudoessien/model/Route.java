package com.aniekanudoessien.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

    @JsonProperty(value = "Description")
    private String description;
    @JsonProperty(value = "Route")
    private String route;

    public Route() {
    }

    public Route(String description, String route) {
        this.description = description;
        this.route = route;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Route{" +
                "description='" + description + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
