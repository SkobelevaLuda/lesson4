package com.example.lesson4.servise;

import com.example.lesson4.model.Ingredient;
import com.example.lesson4.servise.Map;

import java.util.List;

public class Servise {
    private int id=1;

    private Servise(int id) {

        this.id = id+1;
    }

    public final Map<Integer,String> map= new Map<Integer, String>();

    public void add(Integer id, String name){
        map.put(id,name);
    }

    public Map<Integer, String> getId() {
        return getMap();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public static void add(List<String> ingredients) {

    }

}
