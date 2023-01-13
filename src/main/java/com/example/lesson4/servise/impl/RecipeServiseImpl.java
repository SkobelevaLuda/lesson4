package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Recipe;
import com.example.lesson4.model.Recipe;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class RecipeServiseImpl {

    private final Map<Long, Recipe> recipes = new HashMap<>();

    private long idGenerator = 1;

    public Recipe add(Recipe recipe) {
        recipes.put(idGenerator++, recipe);
        return recipe;
    }

    public Optional<Recipe> get(long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    public Optional<Recipe> edit(Long id, Recipe recipe) {
        return Optional.ofNullable(recipes.replace(id, recipe));
    }

    public Optional <Recipe> delite(Long id, Recipe recipe) {
        return Optional.ofNullable(recipes.remove(id));
    }

    public Map<Long, Recipe> getAll() {
        return new HashMap<>(recipes);
    }
}
