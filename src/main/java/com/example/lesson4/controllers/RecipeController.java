package com.example.lesson4.controllers;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.impl.RecipeServiseImpl;
import org.springframework.web.bind.annotation.*;

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
    public Recipe get(@PathVariable long id){
        return recipeServise.get(id);

    }
}
