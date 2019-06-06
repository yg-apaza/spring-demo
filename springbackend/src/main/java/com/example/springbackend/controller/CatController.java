package com.example.springbackend.controller;

import com.example.springbackend.model.Cat;
import com.example.springbackend.service.CatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/cats")
@RestController
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping("")
    public ResponseEntity<List<Cat>> listAllCats() {
        List<Cat> cats = catService.findAllCats();
        if(cats.isEmpty()){
            return new ResponseEntity<List<Cat>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cat>>(cats, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createCat(@RequestBody Cat cat) {
        catService.saveCat(cat);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
