package com.example.project3.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class ValidatedUser {
    @NotEmpty(message="НЕ МОЖЕТЬ БЫТЬ ПУСТЫМ")
    private String name;

    @Min(value = 19,message = "должен быть больше 18")
    private int age;

    public ValidatedUser() {
    }

    public ValidatedUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public @NotEmpty(message = "НЕ МОЖЕТЬ БЫТЬ ПУСТЫМ") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "НЕ МОЖЕТЬ БЫТЬ ПУСТЫМ") String name) {
        this.name = name;
    }

    @Min(value = 19, message = "должен быть больше 18")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 19, message = "должен быть больше 18") int age) {
        this.age = age;
    }
}
