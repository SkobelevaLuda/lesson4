package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.IngredientServise;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class IngredientServiseImpl implements IngredientServise {
    private final Map<Long, Ingredient> ingredients=new HashMap<>();

    private  long idGenerator = 1;

    @Override
    public void add(Ingredient ingredient) {
        ingredients.put(idGenerator++,ingredient);
    }

    @Override
    public void add(Recipe recipe) {

    }

    @Override
    public Ingredient get(long id) {
        return ingredients.get(id);
    }
}
