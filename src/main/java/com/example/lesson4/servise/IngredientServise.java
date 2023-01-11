package com.example.lesson4.servise;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.model.Recipe;
import org.springframework.lang.Nullable;

public interface IngredientServise {
    void add(Ingredient ingredient);

    void add(Recipe recipe);

    @Nullable
    public Ingredient get(long id);
}
