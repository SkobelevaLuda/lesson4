package com.example.lesson4.servise.impl;

import com.example.lesson4.model.Ingredient;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.vm.Continuation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class IngredientServiseImpl {
    private final Map<Long, Ingredient> ingredients = new HashMap<>();

    private long idGenerator = 1;

    public Ingredient add(Ingredient ingredient) {
        ingredients.put(idGenerator++, ingredient);
        return ingredient;
    }
    @Value("${application.path.to.ingredients}")
    private String filesDir;


    public void saveToJsonFileIng(Object object, String fileNameIng) {
        Path path = Path.of(filesDir, fileNameIng);
        try {
            String json = new ObjectMapper().writeValueAsString(object);
            Files.createDirectories(path.getParent());
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.writeString(path, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFileIng(String fileNameIng) {
        try {
            return Files.readString(Path.of(filesDir, fileNameIng));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Ingredient> get(long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    public Optional<Ingredient> edit(Long id, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.replace(id, ingredient));
    }

    public Optional <Ingredient> delite(Long id, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.remove(id));
    }

    public Map<Long, Ingredient> getAll() {
        return new HashMap<>(ingredients);
    }
}
