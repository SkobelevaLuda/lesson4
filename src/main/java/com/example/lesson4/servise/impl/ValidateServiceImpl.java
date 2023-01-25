package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.model.Recipe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ValidateServiceImpl {
    public boolean isNotValid(Recipe recipe) {
        boolean result = StringUtils.isBlank(recipe.getName()) &&
                CollectionUtils.isEmpty(recipe.getSteps());
        if (!result) {
            for (String ingredient : recipe.getSteps()) {
                result = result || isNotValid(recipe);
            }
        }
        return result;


    }

    public boolean validate(Ingredient ingredient) {
        return StringUtils.isNoneBlank(ingredient.getNameIngredirtn()) &&
                StringUtils.isNotBlank(ingredient.getUnit()) &&
                ingredient.getWeigth() > 0;

    }
}
