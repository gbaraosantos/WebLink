package com.weblink.core.common.enums;


import java.util.LinkedList;
import java.util.List;

public enum EvaluationType {
    ONETOTWENTY("1 to 20"),
    ONETOFIVE("1 to 5"),
    ONETOTEN("1 to 10"),
    ATHROUGHE("A through E"),
    INSUFICIENTVERYGOOD("Insuficiente, bom...");

    private String evaluationType;

    EvaluationType(final String evaluationType){
        this.evaluationType = evaluationType;
    }

    public String getEvaluationType(){
        return this.evaluationType;
    }

    @Override
    public String toString(){
        return this.evaluationType;
    }

    public String getName(){
        return this.name();
    }

    public static List<String> getAll(){
        List<String> a = new LinkedList<>();
        a.add(ONETOFIVE.getEvaluationType());
        a.add(ONETOTEN.getEvaluationType());
        a.add(ONETOTWENTY.getEvaluationType());
        a.add(ATHROUGHE.getEvaluationType());
        a.add(INSUFICIENTVERYGOOD.getEvaluationType());

        return a;
    }

    public static EvaluationType whichIs(String i){
        switch (i){
            case("1 to 20"): return ONETOTWENTY;
            case("1 to 5"): return ONETOFIVE;
            case("1 to 10"): return ONETOTEN;
            case("A through E"): return ATHROUGHE;
            case("Insuficiente, bom..."): return INSUFICIENTVERYGOOD;
            default: return ONETOTWENTY;
        }

    }




}
