package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.RecipeServise;
import org.springframework.stereotype.Service;

@Service

public class RecipeServiseImpl implements RecipeServise {

    public int id;

    public RecipeServiseImpl() {
        this.id += id;
    }

    @Override
    public int addRecipe() {
        return id;
    }

    @Override
    public Class<Recipe> receivingRecipe() {
        return Recipe.class;
    }
}
