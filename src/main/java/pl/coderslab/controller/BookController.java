package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping("")
    public List<Book> getBooks() {
        return mockBookService.getBooks();
    }

    @RequestMapping("/{id}")
    public Book get(@PathVariable long id) throws Exception {
        return mockBookService.get(id).get();
    }

    @PostMapping("")
    public void add(@RequestBody Book book) {
        book.setId(mockBookService.getNextId());
        mockBookService.add(book);
    }

    @PutMapping("")
    public void update(@RequestBody Book book) throws Exception {
        mockBookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws Exception {
        mockBookService.delete(id);
    }
}
