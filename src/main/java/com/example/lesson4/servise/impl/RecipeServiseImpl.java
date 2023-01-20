package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class RecipeServiseImpl {

    private static final Map<Long, Recipe> recipes = new HashMap<>();

    private long idGenerator = 1;

    private final Path pathToFile;

    private final ObjectMapper objectMapper;

    public RecipeServiseImpl(@Value("${path.to.files.ricipe}") String path) {
        this.pathToFile = Paths.get(path);
        this.objectMapper = new ObjectMapper();
    }

    public Recipe add(Recipe recipe) {
        recipes.put(idGenerator++, recipe);
        saveToJsonFileRec();
        return recipe;
    }

    @Value("${path.to.files.ricipe}")
    private String recipeFilePath;

    @Value("${name.of.data.recipe}")

    private String recipeFileName;

    public void saveToJsonFileRec() {
        try {
            byte[] data = objectMapper.writeValueAsBytes(recipes);
            Files.write(pathToFile, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void readFromFileRec() {
        try {
            Map<Long, Recipe> fromFile = objectMapper.readValue(Files.readAllBytes(pathToFile),
            new TypeReference(){});

            recipes.putAll(fromFile);

        } catch (IOException e) {
            e.printStackTrace();
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
