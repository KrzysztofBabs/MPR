package com.example.zajecia2.services;

import com.example.zajecia2.controllers.MyRestController;
import com.example.zajecia2.model.Auto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class AutoService {
    List<Auto> listaAut = new ArrayList<>();
    public AutoService(){
        listaAut.add(new Auto("Dacia", 2022));
        listaAut.add(new Auto("Audi", 2023));
        listaAut.add(new Auto("Toyota", 2024));

    }
    public List<Auto> getAll(){
        return this.listaAut;
    }
    public void add(Auto auto){
        this.listaAut.add(auto);
    }

    public void delete(String model){
        listaAut.removeIf(auto -> auto.getModel().equalsIgnoreCase(model));

    }
    public List<Auto> poRokuProdukcji(int rokProdukcji){
        return listaAut.stream().filter(auto -> auto.getRokProdukcji()==rokProdukcji).collect(Collectors.toList());

    }

    public void AktualizujAuto(String model,Auto Noweauto){
        for(int i=0;i<listaAut.size();i++){
            Auto auto = listaAut.get(i);
            if(auto.getModel().equalsIgnoreCase(model)){
                auto.setModel(Noweauto.getModel());
                auto.setRokProdukcji(Noweauto.getRokProdukcji());

            }
        }

    }


}
