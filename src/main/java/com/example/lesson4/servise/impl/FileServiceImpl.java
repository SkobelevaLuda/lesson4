package com.example.lesson4.servise.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.vm.Continuation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

@Service

public class FileServiceImpl {

    @Value("${path.to.files.ingredient}")
    private String filesDir;
    private Continuation filePath;

    public void saveToJsonFileIng(Object object, String fileNameIng) {
        Path path = Path.of(filesDir, fileNameIng + ".json");
        try {
            String json = new ObjectMapper().writeValueAsString(object);
            Files.createDirectories((Path) filePath.getParent());
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.writeString(path, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Value("${path.to.files.ricipe}")
    private String files2Dir;

    public void saveToJsonFileRec(Object object, String fileNameRec) {
        Path path = Path.of(files2Dir, fileNameRec + ".json");
        try {
            String json = new ObjectMapper().writeValueAsString(object);
            Files.createDirectories((Path) filePath.getParent());
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

    public String readFromFileIng(String fileNameIng) {
        try {
            return Files.readString(Path.of(filesDir, fileNameIng));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @PostConstruct

    public String readFromFileRec(String fileNameRec) {
        try {
            return Files.readString(Path.of(files2Dir, fileNameRec));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}





