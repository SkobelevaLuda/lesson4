package com.example.lesson4.controllers;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.RecipeServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {
    private final RecipeServise recipeServise;

    public RecipeController(RecipeServise recipeServise) {
        this.recipeServise = recipeServise;
    }

    @PostMapping
    public Recipe add(@RequestBody Recipe recipe){

        return RecipeServise.add(recipe);
    }

    @GetMapping("/{id}")
    public Recipe get(@PathVariable long id){
        return recipeServise.get(id);

    }
}
