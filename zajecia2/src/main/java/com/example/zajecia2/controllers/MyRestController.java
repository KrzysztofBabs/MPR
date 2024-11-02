package com.example.zajecia2.controllers;

import com.example.zajecia2.model.Auto;
import com.example.zajecia2.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // wyswietlenie aut z repozytorium
    @GetMapping("/auta/zRepo")
    public List<Auto> WyswietlAuta(){
        return autoService.getAll();
    }


    // wyszukanie auta po ID z repozytorium
    @GetMapping("/auto/id/{id}")
    public Optional<Auto> GetById(@PathVariable Long id){
        return autoService.getById(id);
    }


    // wyszukanie auta po modelu z repozytorium
    @GetMapping("/auto/model/{model}")
    public List<Auto> GetByModel(@PathVariable String model){
        return autoService.getByModel(model);
    }


    // wyszukanie auta po roku produkcji z repozytorium
    @GetMapping("/auto/rokProdukcji/{rokProdukcji}")
    public List<Auto> GetByRokProdukcji(@PathVariable int rokProdukcji){
        return autoService.getByRokProdukcji(rokProdukcji);
    }


    // usniecie auta z repozytorium
    @DeleteMapping("/auto/usun/{model}")
    public void usunAuto(@PathVariable String model){
        autoService.delete(model);
    }


    // dodanie auta do repozytorium
    @PostMapping("/auto/dodaj")
    public void dodajAuto(@RequestBody Auto auto){
        autoService.add(auto);
    }

    // aktualizacja auto z repozytorium po ID
    @PatchMapping("/auto/update")
    public void aktualizujAuto(@RequestBody Auto auto){
        autoService.update(auto);
    }



    //zajecia5

    //zamiana na duze litery
    @PostMapping("/auto/dodajj")
    public void dodajAutoDuzeLitery(@RequestBody Auto auto){
        autoService.addupper(auto);
    }


    //zamiana na male litery
    @PostMapping("/auto/dodajjj")
    public void dodajAutoMaleLitery(@RequestBody Auto auto){
        autoService.addlower(auto);
    }

    //pierwsza duza reszta male
    @GetMapping("/auta/zRepoo")
    public List<Auto> WyswietlAutaa(){
        return autoService.getFirstLetterBiggerRestLower();
    }

























}
