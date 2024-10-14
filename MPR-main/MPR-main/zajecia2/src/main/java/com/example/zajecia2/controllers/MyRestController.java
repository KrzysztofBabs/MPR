package com.example.zajecia2.controllers;

import com.example.zajecia2.model.Auto;
import com.example.zajecia2.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController


public class MyRestController {

    private AutoService autoService;
    @Autowired

    public MyRestController(AutoService autoService){
        this.autoService= autoService;
    }
    @GetMapping("/auto/all")
    public List<Auto> getAll(){
        return autoService.getAll();
    }
    @PostMapping("/auto")
    public void addAuto(@RequestBody Auto auto){
        autoService.add(auto);
    }
    @DeleteMapping("/auto/{model}")
    public void deleteAuto(@PathVariable String model){
        autoService.delete(model);
    }

    @GetMapping("/auto/by-rokProdukcji/{rokProdukcji}")
    public List<Auto> WezAutoPoRokuProdukcji(@PathVariable int rokProdukcji){
        return autoService.poRokuProdukcji(rokProdukcji);
    }

    @PutMapping("/auto/aktualizujPoModelu/{model}")
    public void aktualizujAuto(@PathVariable String model, @RequestBody Auto noweAuto){
        autoService.AktualizujAuto(model, noweAuto);

    }
    @GetMapping("/auto/model/{model}")
    public List<Auto> findByModel(@PathVariable String model){
        return this.autoService.getByModel(model);
    }

    @GetMapping("/auto/id/{id}")
    public Optional<Auto> findById(@PathVariable Long id){
        return this.autoService.getById(id);
    }





}
