package com.example.kwadrat_logiczny;

import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class Square {

    // corners -------------------------
    public Corner ld = new Corner();
    public Corner lu = new Corner();
    public Corner ru = new Corner();
    public Corner rd = new Corner();
    //private List<Parameter> parametersLD = new ArrayList<>();


    public Square(String ld, String lu, String ru, String rd) {
        this.ld.setCornerName(ld);
        this.lu.setCornerName(lu);
        this.ru.setCornerName(ru);
        this.rd.setCornerName(rd);
    }

//    public Square(String ld, String lu, String ru, String rd) {
//        this.ld.setCornerName(ld);
//        this.lu.setCornerName(lu);
//        this.ru.setCornerName(ru);
//        this.rd.setCornerName(rd);
//    }


    public Square() {

    }



}
