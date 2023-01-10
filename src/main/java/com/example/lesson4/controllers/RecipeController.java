package com.example.lesson4.controllers;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.RecipeServise;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {
    private RecipeServise recipeServise;

    public RecipeController() {
        this.recipeServise = recipeServise;
    }

    @GetMapping
    public String getRecipe(){
        return recipeServise.receivingRecipe();
    }

}
