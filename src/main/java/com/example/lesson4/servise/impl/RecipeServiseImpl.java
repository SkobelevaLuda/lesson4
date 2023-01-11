package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Recipe;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class RecipeServiseImpl {

    private static final Map<Long,Recipe> recipes=new HashMap<>();

    private static long idGenerator = 1;
@Nullable
    public static Recipe add(Recipe recipe) {
        recipes.put(idGenerator++,recipe);
        return recipe;
    }

    public Recipe get(long id) {
        return recipes.get(id);
    }
}
