package com.example.zajecia2.services;

import com.example.zajecia2.controllers.MyRestController;
import com.example.zajecia2.model.Auto;
import com.example.zajecia2.repository.AutoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

//@Component
@Service
public class AutoService{
    private AutoRepository repository;

    public AutoService(AutoRepository repository){
        this.repository = repository;
        repository.save(new Auto("Dacia", 2022));
        repository.save(new Auto("Audi", 2023));
        repository.save(new Auto("Toyota", 2024));
    }

    public Optional<Auto> getById(Long id){
        return this.repository.findById(id);
    }

    public List<Auto> getByModel(String model){
        return this.repository.findByModel(model);
    }

    public List<Auto> getByRokProdukcji(int rokProdukcji){
        return this.repository.findByRokProdukcji(rokProdukcji);
    }


    public List<Auto> getAll(){
        return this.repository.findAll();
    }

    public void delete(String model){
        List<Auto> auto = this.repository.findByModel(model);
        this.repository.deleteAll(auto);
    }

    public void add(Auto auto){
        this.repository.save(new Auto(auto.getModel(), auto.getRokProdukcji()));

    }

    public void update(Auto auto){
        Long id = auto.getId();
        String model = auto.getModel();
        int rokProdukcji = auto.getRokProdukcji();
        Optional<Auto> car = this.repository.findById(id);
        if(car.isPresent()){
            Auto noweAuto = car.get();
            noweAuto.setModel(model);
            noweAuto.setRokProdukcji(rokProdukcji);
            noweAuto.setIdentyfikator();
            this.repository.save(noweAuto);
        }
        else{
            System.out.println("nie podano dobrego id!");
        }

    }




}




