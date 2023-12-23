package com.workintech.s18Challenge.contoller;

import com.workintech.s18Challenge.dto.AuthorResponse;
import com.workintech.s18Challenge.dto.AuthorResponseWithBooks;
import com.workintech.s18Challenge.dto.BookResponse;
import com.workintech.s18Challenge.entity.Author;
import com.workintech.s18Challenge.entity.Book;
import com.workintech.s18Challenge.service.AuthorService;
import com.workintech.s18Challenge.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    private final BookService bookService;

    @PostMapping
    public Author save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PostMapping("/{bookId}")
    public AuthorResponseWithBooks save(@RequestBody Author author, @PathVariable long bookId) {
        Book foundBook = bookService.findById(bookId);
        author.addBook(foundBook);
        authorService.save(author);
        List<BookResponse> responseList = new ArrayList<>();
        for (Book authorBook : author.getBooks()) {
            responseList.add(new BookResponse(authorBook.getId(), authorBook.getName(), authorBook.getCategory()
                    .getName(), new AuthorResponse(author.getId(),
                    author.getFirstName() + " " + author.getLastName())));
        }
        return new AuthorResponseWithBooks(responseList);
    }
}
