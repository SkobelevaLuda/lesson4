package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.servise.RecipeServise;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class RecipeServiseImpl implements RecipeServise {

    private final Map<Long,Recipe> recipes=new HashMap<>();

    private  long idGenerator = 1;

    @Override
    public void add(Recipe recipe) {
        recipes.put(idGenerator++,recipe);
    }

    @Override
    public Recipe get(long id) {
        return recipes.get(id);
    }
}
