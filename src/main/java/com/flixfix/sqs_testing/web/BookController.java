package com.flixfix.sqs_testing.web;

import com.flixfix.sqs_testing.service.BookDto;
import com.flixfix.sqs_testing.service.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Endpoints for managing book availability and lending")
public class BookController {

    private final LibraryService service;

    public BookController(LibraryService service) {
        this.service = service;
    }

    @Operation(summary = "Get available books", description = "Retrieves a list of all currently available books in the library.")
    @ApiResponse(responseCode = "200", description = "List of available books returned successfully")
    @GetMapping("/available")
    public List<BookDto> available() {
        return service.getAvailableBooks();
    }

    @Operation(summary = "Get lent books", description = "Retrieves a list of books that are currently lent out.")
    @ApiResponse(responseCode = "200", description = "List of lent books returned successfully")
    @GetMapping("/lent")
    public List<BookDto> lent() {
        return service.getLentBooks();
    }

    @Operation(summary = "Lend a book", description = "Marks the book with the given ID as lent.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book lent successfully"),
            @ApiResponse(responseCode = "404", description = "Book with the given ID not found"),
            @ApiResponse(responseCode = "400", description = "Book is already lent or unavailable")
    })
    @PostMapping("/lend/{id}")
    public void lend(@PathVariable Long id) {
        service.lendBook(id);
    }
}
