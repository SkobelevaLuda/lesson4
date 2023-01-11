package com.example.lesson4.servise;

import com.example.lesson4.model.Recipe;
import org.springframework.lang.Nullable;

public interface RecipeServise {

    public static Recipe add() {
        return null;
    }

    void add(Recipe recipe);

    @Nullable
    public Recipe get(long id);
}
