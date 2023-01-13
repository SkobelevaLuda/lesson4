package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Recipe;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class RecipeServiseImpl {

    private final Map<Long, Recipe> recipes = new HashMap<>();

    private long idGenerator = 1;

    public Recipe add(Recipe recipe) {
        recipes.put(idGenerator++, recipe);
        return recipe;
    }

    @Nullable
    public Recipe get(long id) {

        return recipes.get(id);
    }

    public Recipe edit(Long id, Recipe recipe) {
        return null;
    }

    public Recipe delite(Long id, Recipe recipe) {
        return null;
    }
}
