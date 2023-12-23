package com.workintech.s18Challenge.dto;

public record BookResponse(long id, String name, String categoryName, AuthorResponse authorResponse) {
}
