package com.example.lesson4.servise;

public class Servise {
    private int id=1;
    private Object recipe;

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
}
