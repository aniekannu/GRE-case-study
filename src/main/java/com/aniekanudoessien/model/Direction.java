package com.aniekanudoessien.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Direction {

    @JsonProperty(value = "Text")
    private String text;
    @JsonProperty(value = "Value")
    private String value;

    public Direction() {
    }

    public Direction(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
