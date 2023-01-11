package com.example.lesson4.controllers;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.servise.impl.IngredientServiseImpl;
import org.springframework.web.bind.annotation.*;

@RestController

public class IngredientController {

    private IngredientServiseImpl ingredientServise;

    public void IngredientServise(IngredientServiseImpl ingredientServise) {
        this.ingredientServise = ingredientServise;
    }

    @PostMapping("/ingredient")
    public Ingredient add(@RequestBody Ingredient ingredient){

        return IngredientServiseImpl.add(ingredient);
    }

    @GetMapping("/ingredient/{id}")
    public Ingredient get(@PathVariable long id){
        return ingredientServise.get(id);

    }
}
