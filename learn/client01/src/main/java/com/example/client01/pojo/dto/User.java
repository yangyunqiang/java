package com.example.client01.pojo.dto;

public class User {
    private String name;
    private Integer age;

    public User(String n, int i) {
        name = n;
        age = i;
    }

    public String getNama() {
        return name;
    }

    public void setNama(String nama) {
        this.name = nama;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
