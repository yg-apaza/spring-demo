package com.example.springbackend.service;

import com.example.springbackend.model.Cat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@PropertySource("classpath:application.properties")
public class CatServiceImpl implements CatService {

    private static final AtomicLong counter = new AtomicLong();
    
    @Value("${store.path}")
    private String STORE_PATH;

    public List<Cat> findAllCats() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(STORE_PATH);
        try {
            return objectMapper.readValue(file, new TypeReference<List<Cat>>(){});
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public void saveCat(Cat cat) {
        cat.setId(counter.incrementAndGet());
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(STORE_PATH);
        try {
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            ArrayList<Cat> cats = new ArrayList<Cat>(this.findAllCats());
            cats.add(cat);
            writer.writeValue(file, cats);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
