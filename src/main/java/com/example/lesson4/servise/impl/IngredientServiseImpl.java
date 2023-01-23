package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.model.Recipe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class IngredientServiseImpl {
    private final Map<Long, Recipe> ingredients = new HashMap<Long, Recipe>();

    private long idGenerator = 1;

    private static Path pathToFile;

    private final ObjectMapper objectMapper;

    public IngredientServiseImpl(@Value("${application.path.to.ingredients}") String path) {
        this.pathToFile = Paths.get(path);
        this.objectMapper = new ObjectMapper();
    }

    public void saveToJsonFileIngred() {
        try {
            byte[] data = objectMapper.writeValueAsBytes(ingredients);
            Files.write(pathToFile, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void readFromFileIngred() {
        try {

            Map<Long, Recipe> fromFile = objectMapper.readValue(Files.readAllBytes(pathToFile),
                    new TypeReference<>() {

                    });
            ingredients.putAll(fromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, (Recipe) ingredients);
        saveToJsonFileIngred();
        return ingredient;

    }

    public static File getIngredientDataFile(){
        return new File(pathToFile.toUri());
    }

    public boolean cleanIngrediientFile(){
        try {
            Path path=Path.of(pathToFile.toUri());
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }



    public Optional<Recipe> get(long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    public Optional<Recipe> edit(Long id, Ingredient ingredient) {
        saveToJsonFileIngred();
        return Optional.ofNullable(ingredients.replace(id, (Recipe) ingredients));
    }

    public Optional<Recipe> delite(Long id, Ingredient ingredient) {
        saveToJsonFileIngred();
        return Optional.ofNullable(ingredients.remove(id));
    }

    public Map<Long, Recipe> getAll() {

        return new HashMap<>(ingredients);
    }
}
