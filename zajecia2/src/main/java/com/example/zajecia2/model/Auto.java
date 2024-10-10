package com.example.zajecia2.model;

public class Auto {
    private String model;
    private int rokProdukcji;

    public Auto(String model, int rokProdukcji) {
        this.model = model;
        this.rokProdukcji = rokProdukcji;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }
}
