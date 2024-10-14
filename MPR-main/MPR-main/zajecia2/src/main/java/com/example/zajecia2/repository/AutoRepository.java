package com.example.zajecia2.repository;

import com.example.zajecia2.model.Auto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AutoRepository extends CrudRepository<Auto,Long>{
    public List<Auto> findByModel(String model);
    public Auto findById(long Id);




}
