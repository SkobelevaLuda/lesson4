package com.example.lesson4.controllers;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.servise.impl.IngredientServiseImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")

public class IngredientController {

    private IngredientServiseImpl ingredientServise;

    public void IngredientServise(IngredientServiseImpl ingredientServise) {
        this.ingredientServise = ingredientServise;
    }

    @PostMapping
    public Ingredient add(@RequestBody Ingredient ingredient){

        return ingredientServise.add(ingredient);
    }


}
