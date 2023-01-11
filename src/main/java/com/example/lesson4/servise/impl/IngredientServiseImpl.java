package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class IngredientServiseImpl {
    private static final Map<Long, Ingredient> ingredients = new HashMap<>();

    private static long idGenerator = 1;

    @Nullable
    public static Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return ingredient;
    }


    public Ingredient get(long id) {
        return ingredients.get(id);
    }
}
