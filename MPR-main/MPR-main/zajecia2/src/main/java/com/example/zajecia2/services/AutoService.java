package com.example.zajecia2.services;

import com.example.zajecia2.controllers.MyRestController;
import com.example.zajecia2.model.Auto;
import com.example.zajecia2.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AutoService {
    private AutoRepository repository;

    static List<Auto> listaAut = new ArrayList<>();

    @Autowired
    public AutoService(AutoRepository repository) {
        this.repository = repository;
        repository.save(new Auto("Dacia", 2022));
        repository.save(new Auto("Audi", 2023));
        repository.save(new Auto("Toyota", 2024));
    }

//
//    public AutoService(){
//        listaAut.add(new Auto("Dacia", 2022));
//        listaAut.add(new Auto("Audi", 2023));
//        listaAut.add(new Auto("Toyota", 2024));
//
//
//    }
    public List<Auto> getByModel(String model){
        return this.repository.findByModel(model);
    }
    public Optional<Auto> getById(Long id){
        return this.repository.findById(id);
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
