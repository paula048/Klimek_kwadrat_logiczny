package com.example.kwadrat_logiczny;

import java.util.ArrayList;
import java.util.List;

public class Corner {

    private String cornerName;
    private List<Parametr> parameters = new ArrayList<>();








    public String getCornerName() {
        return cornerName;
    }
    public void setCornerName(String cornerName) {
        this.cornerName = cornerName;
    }


    public List<Parametr> getParameters() {
        return parameters;
    }
    public void setParameters(List<Parametr> parameters) {
        this.parameters = parameters;
    }








}
