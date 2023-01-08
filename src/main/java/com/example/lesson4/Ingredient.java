package com.example.lesson4;

import java.util.List;
import java.util.Objects;

public class Ingredient {
    private String nameIngredirtn;
    private int weith;
    private String unit;

    public static void add(List<String> ingredients) {


    }
    public void addIngredients(List<String> ingredients) {

        Ingredient.add(ingredients);
    }

    public Ingredient(String nameIngredirtn, int weith, String unit) {
        this.nameIngredirtn = nameIngredirtn;
        this.weith = weith;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return weith == that.weith && nameIngredirtn.equals(that.nameIngredirtn) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameIngredirtn, weith, unit);
    }
}
