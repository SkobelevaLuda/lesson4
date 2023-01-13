package com.example.lesson4.controllers;

import com.example.lesson4.model.Recipe;
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
