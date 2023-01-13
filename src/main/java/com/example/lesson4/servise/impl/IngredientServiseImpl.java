package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class IngredientServiseImpl {
    private final Map<Long, Ingredient> ingredients = new HashMap<>();

    private long idGenerator = 1;

    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return ingredient;
    }

    public Ingredient get(long id) {
        return ingredients.get(idGenerator);
    }

    public Ingredient edit(Long id, Ingredient ingredient) {
        return null;
    }

    public Ingredient delite(Long id, Ingredient ingredient) {
        return null;
    }

    public Map<Long, Ingredient> getAll() {
        return new HashMap<>(ingredients);
    }
}
