package com.example.lesson4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private String name;
    private int timeUnit;
    private List<Ingredient> ingredients;

    private List<String> steps;
    private CharSequence titel;


    public CharSequence getTitel() {
        return titel;
    }
}

