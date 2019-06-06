package com.example.springbackend.service;

import java.util.List;

import com.example.springbackend.model.Cat;

public interface CatService {

    List<Cat> findAllCats();
    void saveCat(Cat cat);

}
