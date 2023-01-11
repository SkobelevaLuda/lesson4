package com.example.lesson4.controllers;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.impl.RecipeServiseImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {
    private final RecipeServiseImpl recipeServise;

    public RecipeController(RecipeServiseImpl recipeServise) {
        this.recipeServise = recipeServise;
    }

    @PostMapping("/recipe")
    public Recipe add(@RequestBody Recipe recipe){

        return RecipeServiseImpl.add(recipe);
    }

    @GetMapping("/recipe/{id}")
    public Recipe get(@PathVariable long id){
        return recipeServise.get(id);

    }
}
