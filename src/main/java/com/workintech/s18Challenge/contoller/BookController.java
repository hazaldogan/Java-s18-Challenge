package com.workintech.s18Challenge.contoller;

import com.workintech.s18Challenge.dto.AuthorResponse;
import com.workintech.s18Challenge.dto.BookResponse;
import com.workintech.s18Challenge.entity.Author;
import com.workintech.s18Challenge.entity.Book;
import com.workintech.s18Challenge.entity.Category;
import com.workintech.s18Challenge.service.AuthorService;
import com.workintech.s18Challenge.service.BookService;
import com.workintech.s18Challenge.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable long categoryId) {
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName(), null);
    }

    @PostMapping("/saveByAuthor")
    public BookResponse save(@RequestBody Book book, @RequestParam long categoryId, @RequestParam long authorId) {
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        Author author = authorService.findById(authorId);
        book.setAuthor(author);
        author.addBook(book);

        bookService.save(book);

        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName(),
                new AuthorResponse(author.getId(), author.getFirstName() + " " + author.getLastName()));
    }
}
