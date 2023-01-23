package com.example.lesson4.controllers;

import com.example.lesson4.servise.impl.IngredientServiseImpl;
import com.example.lesson4.servise.impl.RecipeServiseImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController

@RequestMapping("/files")

public class FilesController {
    private final RecipeServiseImpl recipeServise;

    private final IngredientServiseImpl ingredientServise;

    public FilesController(RecipeServiseImpl recipeServise, IngredientServiseImpl ingredientServise) {
        this.recipeServise = recipeServise;
        this.ingredientServise = ingredientServise;
    }

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> dowloadRecipeFile() throws FileNotFoundException {
        File file = recipeServise.getRecipeDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"Recipe.json\"")
                    .body(resource);

        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/exporting")
    public ResponseEntity<InputStreamResource> dowloadIngredientFile() throws FileNotFoundException {
        File fileIng = ingredientServise.getIngredientDataFile();
        if (fileIng.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(fileIng));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(fileIng.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"Ingredient.json\"")
                    .body(resource);

        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadRecipeFile(@RequestParam MultipartFile file) {
        recipeServise.cleanRecipeFile();
        File recipeFile = RecipeServiseImpl.getRecipeDataFile();

        try (FileOutputStream fos = new FileOutputStream(recipeFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value = "/importing", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadIngredientFile(@RequestParam MultipartFile file) {
        ingredientServise.cleanIngrediientFile();
        File ingredientFile = IngredientServiseImpl.getIngredientDataFile();

        try (FileOutputStream fos = new FileOutputStream(ingredientFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
