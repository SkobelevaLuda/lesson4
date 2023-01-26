package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.model.Recipe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ValidateServiceImpl {


    public boolean validate(Ingredient ingredient) {
        return StringUtils.isNoneBlank(ingredient.getNameIngredirtn()) &&
                StringUtils.isNotBlank(ingredient.getUnit()) &&
                ingredient.getWeigth() > 0;

    }

    public boolean validate(Recipe recipe) {
        return StringUtils.isNoneBlank(recipe.getName()) &&
                StringUtils.isNotBlank(recipe.getName()) &&
                recipe.getSteps() !=null;
    }
}
