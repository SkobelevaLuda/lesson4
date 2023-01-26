package com.example.lesson4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private String name ;
    private int time;

    private List<Ingredient> ingredients;

    private List<String> steps;




    @Override
    public String toString() {
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append(name).append("\n")
                .append("Время приготовления: ").append(time).append("минут").append("\n")
                .append("ингредиенты: ").append("\n");
        for (Ingredient ingredient : ingredients){
            stringBuilder.append("*").append(ingredient).append("\n");
        }
        stringBuilder.append("Инструкция приготовления: ").append("\n");
        int counter =1;
        for (String step: steps){
            stringBuilder.append(counter++).append(". ").append(step).append("\n");
        }
        return stringBuilder.toString();
    }
}

