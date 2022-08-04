package com.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;
import lombok.With;

@With
@Getter
public class Course  {
    private final Long id;
    private final String author;
    private final String title;

    @JsonCreator
    public Course(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }
}
