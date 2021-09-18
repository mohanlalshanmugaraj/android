package com.example.listproject;

import java.io.Serializable;

public class cakes implements Serializable {
    public String cake_name;
    public String cake_kg;
    public String cake_quentity;

    public cakes() {

    }

    public cakes(String cake_name, String cake_kg, String cake_quentity) {
        this.cake_name = cake_name;
        this.cake_kg = cake_kg;
        this.cake_quentity = cake_quentity;
    }

    public String getCake_name() {
        return cake_name;
    }

    public void setCake_name(String cake_name) {
        this.cake_name = cake_name;
    }

    public String getCake_kg() {
        return cake_kg;
    }

    public void setCake_kg(String cake_kg) {
        this.cake_kg = cake_kg;
    }

    public String getCake_quentity() {
        return cake_quentity;
    }

    public void setCake_quentity(String cake_quentity) {
        this.cake_quentity = cake_quentity;
    }
}
