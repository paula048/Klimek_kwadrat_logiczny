package com.example.kwadrat_logiczny;

public class Parametr {
    private String name = "@";
    private Boolean value = false;

    public Parametr(String name) {
        this.name = name;
        this.value = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
