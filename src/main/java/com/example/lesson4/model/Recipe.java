package com.example.lesson4.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class Recipe {
    public String name;
    private int timeUnit;
    public List<String> ingredients;

    public List<String> steps;

    public Recipe(String name, int timeUnit, List<String> ingredients, List<String> steps) {
        if (name==null||name.isEmpty()){
            System.out.println("Заполните информацию");
        }else {
            this.name = name;
        }
        if (timeUnit==0){
            System.out.println("Не верное время");
        }else{
            this.timeUnit = timeUnit;
        }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeUnit() {
        return timeUnit;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public <K, V> Object getIngredients(LinkedHashMap<K,V> kvLinkedHashMap) {
        return ingredients;
    }

}

