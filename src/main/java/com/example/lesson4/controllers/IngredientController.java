package com.example.lesson4.controllers;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.servise.impl.IngredientServiseImpl;
import com.example.lesson4.servise.impl.ValidateServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Tag(name = "IngredientController", description = " API для рецептов")
@RestController
@RequestMapping("/ingredient")

public class IngredientController {

    private IngredientServiseImpl ingredientServise;

    private final ValidateServiceImpl validateService;

    public IngredientController(IngredientServiseImpl ingredientServise, ValidateServiceImpl validateService) {
        this.ingredientServise = ingredientServise;
        this.validateService = validateService;
    }
    @ApiResponses({
            @ApiResponse
    })

    @PostMapping
    public ResponseEntity<Ingredient> add(@RequestBody Ingredient ingredient){
        if (!validateService.validate(ingredient)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ingredientServise.add(ingredient));
    }
    @GetMapping("/{id}")
    public ResponseEntity <Ingredient> get(@PathVariable long id) {
        return ResponseEntity.of(ingredientServise.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Ingredient> edit(@PathVariable Long id,
                                            @RequestBody Ingredient ingredient){
        if (!validateService.validate(ingredient)){
            return ResponseEntity.badRequest().build();
        }
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
