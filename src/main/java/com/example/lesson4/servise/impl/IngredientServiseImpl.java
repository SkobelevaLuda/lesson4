package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class IngredientServiseImpl {
    private final Map<Long, Ingredient> ingredients = new HashMap<>();

    private long idGenerator = 1;

    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return ingredient;
    }

    public Optional<Ingredient> get(long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    public Optional<Ingredient> edit(Long id, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.replace(id, ingredient));
    }

    public Optional <Ingredient> delite(Long id, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.remove(id));
    }

    public Map<Long, Ingredient> getAll() {
        return new HashMap<>(ingredients);
    }
}
