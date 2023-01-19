package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class RecipeServiseImpl {

    private static final Map<Long, Recipe> recipes = new HashMap<>();

    private long idGenerator = 1;

    public Recipe add(Recipe recipe) {
        recipes.put(idGenerator++, recipe);
        return recipe;
    }

    @Value("${path.to.files.ricipe}")
    private String recipeFilePath;

    @Value("recipe.json")
    private String recipeFileName;

    @PostConstruct
    public void saveToJsonFileRec(Object object, String recipeFileName) {
        Path path = Path.of(recipeFilePath, recipeFileName + "recipe.json");
        try {
            String json = new ObjectMapper().writeValueAsString(object);
            Files.createDirectories(path.getParent());
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.writeString(path, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public String readFromFileRec() {
        try {
            return Files.readString(Path.of(recipeFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Recipe> get(long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    public Optional<Recipe> edit(Long id, Recipe recipe) {
        return Optional.ofNullable(recipes.replace(id, recipe));
    }

    public Optional<Recipe> delite(Long id, Recipe recipe) {
        return Optional.ofNullable(recipes.remove(id));
    }

    public Map<Long, Recipe> getAll() {
        return new HashMap<>(recipes);
    }
}
