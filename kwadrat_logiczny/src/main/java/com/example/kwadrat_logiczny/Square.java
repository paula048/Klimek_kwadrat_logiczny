package com.example.kwadrat_logiczny;

import javafx.event.ActionEvent;

public class Square {

    public String getLd() {
        return ld;
    }

    public void setLd(String ld) {
        this.ld = ld;
    }

    public String getLu() {
        return lu;
    }

    public void setLu(String lu) {
        this.lu = lu;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    private String ld;
    private String lu;
    private String ru;
    private String rd;

    public Integer getLdState() {
        return ldState;
    }

    public void setLdState(Integer ldState) {
        this.ldState = ldState;
    }

    public Integer getLuState() {
        return luState;
    }

    public void setLuState(Integer luState) {
        this.luState = luState;
    }

    public Integer getRuState() {
        return ruState;
    }

    public void setRuState(Integer ruState) {
        this.ruState = ruState;
    }

    public Integer getRdState() {
        return rdState;
    }

    public void setRdState(Integer rdState) {
        this.rdState = rdState;
    }

    private Integer ldState = null;
    private Integer luState = null;
    private Integer ruState = null;
    private Integer rdState = null;


    public Square(String ld, String lu, String ru, String rd) {
        this.ld = ld;
        this.lu = lu;
        this.ru = ru;
        this.rd = rd;
    }

    public Square() {

    }



}
