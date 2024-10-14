package com.in28minutes.restful_web_services.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {

    private long id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @Past(message = "Birth date should be in the past")
    @NotNull(message = "Birth date is mandatory")
    private LocalDate birthDate;

    public User() {}

    public User(long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User: [ID: %d, Name: %s, Birth Date: %s]".formatted(id, name, birthDate);
    }
}
