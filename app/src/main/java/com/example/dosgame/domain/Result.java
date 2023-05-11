package com.example.dosgame.domain;

public class Result {
    private int id;
    private String name;
    private String time;

    public Result(int id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public Result(String time) {
        name = "anonymous";
        this.time = time;
    }

    public Result(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
