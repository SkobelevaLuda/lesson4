package com.example.lesson4.servise.impl;
import com.example.lesson4.model.Recipe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
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

public class RecipeServiseImpl {

    private static final Map<Long, Recipe> recipes = new HashMap<>();

    private long idGenerator = 1;

    private static Path pathToFile;

    private final ObjectMapper objectMapper;

    public RecipeServiseImpl(@Value("./src/recipes.json") String path, ObjectMapper objectMapper) {
        pathToFile =Paths.get(path);
        this.objectMapper = objectMapper;
    }

    public Recipe add(Recipe recipe) {
        recipes.put(idGenerator++, recipe);
        saveToJsonFileRec();
        return recipe;
    }

    public boolean cleanRecipeFile() {
        try {
            Path path = Path.of(pathToFile.toUri());
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveToJsonFileRec() {
        try {
            byte[] data = objectMapper.writeValueAsBytes(recipes);
            Files.write(pathToFile, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getRecipeDataFile() {
        return new File(pathToFile.toUri());
    }

    @PostConstruct
    public void readFromFileRec() {
        try {

           Map<Long, Recipe> fromFile = objectMapper.readValue(Files.readAllBytes(pathToFile),
                   new TypeReference<>() {


                    });
            recipes.putAll(fromFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable

    public Optional <Recipe> get(long id) {

        return Optional.ofNullable(recipes.get(id));
    }

    public Optional<Recipe> edit(Long id, Recipe recipe) {
        Optional<Recipe> result = Optional.ofNullable(recipes.replace(id, recipe));
        saveToJsonFileRec();
        return result;
    }

    public Optional<Recipe> delite(Long id, Recipe recipe) {
        Optional<Recipe> result = Optional.ofNullable(recipes.remove(id));
        saveToJsonFileRec();
        return result;
    }

    public Map<Long, Recipe> getAll(RecipeServiseImpl recipeServise) {
        return new HashMap<>();
    }
}
