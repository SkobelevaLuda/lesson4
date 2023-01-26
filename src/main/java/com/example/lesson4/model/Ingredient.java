package com.example.lesson4.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private String nameIngredirtn;
    private int weigth;
    private String unit;

    @Override
    public String toString() {
        return nameIngredirtn + " - " + weigth +" - " + unit ;
    }
}
