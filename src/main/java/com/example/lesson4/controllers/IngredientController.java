package com.example.lesson4.controllers;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.servise.impl.IngredientServiseImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @GetMapping("/{id}")
    public ResponseEntity <Ingredient> get(@PathVariable long id) {
        return ResponseEntity.of(ingredientServise.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Ingredient> edit(@PathVariable Long id, @RequestBody Ingredient ingredient){
        return ResponseEntity.of(ingredientServise.edit(id, ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Ingredient> delite(@PathVariable Long id, @RequestBody Ingredient ingredient){
        return ResponseEntity.of(ingredientServise.delite(id, ingredient));
    }

    @GetMapping
    public Map<Long,Ingredient> getAll(){
        return ingredientServise.getAll();
    }



}
