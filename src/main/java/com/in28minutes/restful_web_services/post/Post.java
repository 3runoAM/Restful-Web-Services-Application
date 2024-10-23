package com.in28minutes.restful_web_services.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.restful_web_services.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Size(min = 10, max = 50)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    protected Post(String description) {
        this.description = description;
    }

    protected Post() {

    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setUser(@NotNull User user) {
        this.user = user;
    }
}
