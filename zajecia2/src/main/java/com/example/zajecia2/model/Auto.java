package com.example.zajecia2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private int rokProdukcji;
    private int identyfikator;



    public Auto(String model, int rokProdukcji) {
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.setIdentyfikator();

    }
    public Auto(){};


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator() {
        char[] tablica1 = this.model.toCharArray();
        char[] tablica2 = ("" + this.rokProdukcji).toCharArray();
        int a=0;
        for(char x : tablica1){
            a+=(int) x;
        }
        for(char x : tablica2){
            a+=(int) x;
        }
        this.identyfikator = a;


    }
}
