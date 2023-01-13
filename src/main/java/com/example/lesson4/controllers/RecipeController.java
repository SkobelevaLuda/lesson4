package com.example.lesson4.controllers;

import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.impl.RecipeServiseImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeServiseImpl recipeServise;

    public RecipeController(RecipeServiseImpl recipeServise) {

        this.recipeServise = recipeServise;
    }

    @PostMapping
    public Recipe add(@RequestBody Recipe recipe){

        return recipeServise.add(recipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Recipe> get(@PathVariable long id) {
        return ResponseEntity.of(recipeServise.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Recipe> edit(@PathVariable Long id, @RequestBody Recipe recipe){
        return ResponseEntity.of(recipeServise.edit(id, recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Recipe> delite(@PathVariable Long id, @RequestBody Recipe recipe){
        return ResponseEntity.of(recipeServise.delite(id, recipe));
    }

    @GetMapping
    public Map<Long,Recipe> getAll(){
        return recipeServise.getAll();
    }
}
