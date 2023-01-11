package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class IngredientServiseImpl {
    private static final Map<Long, Ingredient> ingredients = new HashMap<>();

    private long idGenerator = 1;

    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return ingredient;
    }

@Nullable
    public Ingredient gettt(long id) {
        return ingredients.get(id);
    }
}
