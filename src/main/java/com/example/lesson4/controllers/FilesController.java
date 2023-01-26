package com.example.lesson4.controllers;

import com.example.lesson4.servise.impl.IngredientServiseImpl;
import com.example.lesson4.servise.impl.RecipeServiseImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController

@RequestMapping("/files")

public class FilesController {
    private final RecipeServiseImpl recipeServise;

    private final IngredientServiseImpl ingredientServise;

    public FilesController(RecipeServiseImpl recipeServise, IngredientServiseImpl ingredientServise) {
        this.recipeServise = recipeServise;
        this.ingredientServise = ingredientServise;
    }


    @GetMapping("/recipe/download")
    public ResponseEntity<byte[]> download() {
        byte[] data = recipeServise.download();
        if (data == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .contentLength(data.length)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipe.json\"")
                .body(data);
    }

    @GetMapping("/ingredient/download")
    public ResponseEntity<byte[]> downloadIngredient() {
        byte[] data = ingredientServise.download();
        if (data == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .contentLength(data.length)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"ingredient.json\"")
                .body(data);
    }

    @PostMapping("/recipe/import")
    public void importData(@RequestParam("file") MultipartFile multipartFile) {
        try {
            recipeServise.importData(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/ingredient/import")
    public void importDataIngredient(@RequestParam("file") MultipartFile multipartFile) {
        try {
            ingredientServise.importData(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/recipe/export")
    public ResponseEntity<byte[]> downloadExport() {
        byte[] data = recipeServise.export();
        if (data == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .contentLength(data.length)
                .contentType(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipe.txt\"")
                .body(data);
    }
}


