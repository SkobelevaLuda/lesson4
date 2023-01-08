package com.example.lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private int timeUnit;
    public List<String> ingredients = new ArrayList<>();

    public List<String> steps = new ArrayList<>();

    public Recipe(String name, int timeUnit, List<String> ingredients, List<String> steps) {
        this.name = name;
        this.timeUnit = timeUnit;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return timeUnit == recipe.timeUnit && name.equals(recipe.name) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(steps, recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timeUnit, ingredients, steps);
    }
}

