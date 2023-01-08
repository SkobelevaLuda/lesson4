package com.example.lesson4.servise;

public class ServiseIngredient {
    private int idd=1;

    public ServiseIngredient(int idd) {
        this.idd += idd;
    }

    private static final Map<Integer, String> map= new Map<>();

    public void addIngredient(Integer idd, String nameIngredirtn){
        map.put(idd,nameIngredirtn);
    }

    public Map<Integer, String> getIdd() {
        return map;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }
}
