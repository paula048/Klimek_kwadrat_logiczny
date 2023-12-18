package com.example.kwadrat_logiczny;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Corner {

    private String cornerName;
    public List<Parametr> parameters = new ArrayList<>();
    public Tooltip tooltip = null;
    public Button cornerButton = null;


    public void setTooltip(Button btn) {
        this.cornerButton = btn;
        this.tooltip = new Tooltip("No added PARAMETERS");
        this.tooltip.setShowDelay(Duration.seconds(0));
        Tooltip.install(this.cornerButton, this.tooltip);

    }

    public String parametersAsString() {

        String txt = "No added PARAMETERS";
        if(this.parameters.size()>0){
            txt="PARAMETERS\t[name] : [value]\n";
            for(Parametr tmp : this.parameters){
                txt += tmp.getName()+":\t"+tmp.getValue()+"\n";
            }
        }


        return txt;
    }

    public void install_Tooltip() {
        Tooltip.install(this.cornerButton, this.tooltip);
        this.tooltip.setText(parametersAsString());
    }

    public void uninstall_Tooltip() {
        Tooltip.uninstall(this.cornerButton, this.tooltip);
    }


//    Tooltip t_A = new Tooltip("SEKS");
//        Tooltip.install(b1, t_A);
//        t_A.setShowDelay(Duration.seconds(0));







    public String getCornerName() {
        return cornerName;
    }
    public void setCornerName(String cornerName) {
        this.cornerName = cornerName;
    }

    public List<Parametr> getParametersList() {
        return parameters;
    }
    public Parametr getParameterByIndex(int index) {
        return parameters.get(index);
    }
    public void addParameter(Parametr parameter) {
        this.parameters.add(parameter);
    }




}
