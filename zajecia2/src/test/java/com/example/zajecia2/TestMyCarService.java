package com.example.zajecia2;

import com.example.zajecia2.model.Auto;
import com.example.zajecia2.repository.AutoRepository;
import com.example.zajecia2.services.AutoService;
import com.example.zajecia2.services.StringUtilsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TestMyCarService {
    AutoRepository autoRepository;
    StringUtilsService stringUtilsService;
    AutoService autoService;

    @BeforeEach
    public void setUp(){
        this.autoRepository = Mockito.mock(AutoRepository.class);
        this.stringUtilsService = Mockito.mock(StringUtilsService.class);
        this.autoService = new AutoService(autoRepository, stringUtilsService);

    }

    @Test
    public void lettersToUpperCaseTest(){
        // trzeba bylo dodac w klasie Auto metody equals i hashCode
        Auto auto = new Auto("Toyota", 2024);
        when(stringUtilsService.upper("Toyota")).thenReturn("TOYOTA");
        autoService.addupper(auto);
        verify(stringUtilsService,times(1)).upper("Toyota"); //sprawdzenie ze metoda lower zostala wywolana dokladnie raz z argumentem "Toyota"
//        assertEquals("TOYOTA", auto.getModel());
        verify(autoRepository,times(1)).save(new Auto("TOYOTA",2024));
    }

    @Test
    public void lettersToLowerCaseTest(){
        Auto auto = new Auto("ToYota", 2025);
        when(stringUtilsService.lower("ToYota")).thenReturn("toyota");
        autoService.addlower(auto);
        verify(stringUtilsService,times(1)).lower("ToYota");
        verify(autoRepository,times(1)).save(new Auto("toyota",2025));


    }

    @Test
    public void FirstBiggerRestLowerTest(){
        Auto auto1 = new Auto("DAcIa", 2022);
        Auto auto2 = new Auto("FORd", 2023);

        List<Auto> auta = Arrays.asList(auto1,auto2);
        when(autoRepository.findAll()).thenReturn(auta);
        when(stringUtilsService.firstBigger("DAcIa")).thenReturn("Dacia");
        when(stringUtilsService.firstBigger("FORd")).thenReturn("Ford");

        List<Auto> result = autoService.getFirstLetterBiggerRestLower();

//        verify(stringUtilsService,times(1)).firstBigger("DAcIa");
//        verify(stringUtilsService,times(1)).firstBigger("FORd");
//        verify(autoRepository,times(1)).findAll();
        assertEquals("Dacia", result.get(0).getModel());
        assertEquals("Ford", result.get(1).getModel());



    }

    @Test
    public void IDHasExceptedValue(){
        Auto auto = Mockito.spy(new Auto("Ford", 2024));
        int exceptedValue = 595;
        autoService.add(auto);
        verify(auto,times(1)).setIdentyfikator();
        assertEquals(exceptedValue,auto.getIdentyfikator());

    }

}
