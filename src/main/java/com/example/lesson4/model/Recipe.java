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

    private List<String> steps;

    private String titel;

   }

