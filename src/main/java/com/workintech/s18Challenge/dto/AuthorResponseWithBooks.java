package com.workintech.s18Challenge.dto;

import java.util.List;

public record AuthorResponseWithBooks(List<BookResponse> responseList) {
}
