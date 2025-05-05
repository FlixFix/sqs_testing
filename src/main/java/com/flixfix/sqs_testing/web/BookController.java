package com.flixfix.sqs_testing.web;

import com.flixfix.sqs_testing.service.BookDto;
import com.flixfix.sqs_testing.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final LibraryService service;

    public BookController(LibraryService service) { this.service = service; }

    @GetMapping("/available")
    public List<BookDto> available() {
        return service.getAvailableBooks();
    }

    @GetMapping("/lent")
    public List<BookDto> lent() {
        return service.getLentBooks();
    }

    @PostMapping("/lend/{id}")
    public void lend(@PathVariable Long id) {
        service.lendBook(id);
    }
}

