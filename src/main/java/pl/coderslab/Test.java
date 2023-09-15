package pl.coderslab;

import pl.coderslab.model.Book;
import pl.coderslab.model.MockBookService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MockBookService mockBookService = new MockBookService();
        List<Book> books = mockBookService.getBooks();
        int i = books.indexOf(books.get(0));
        System.out.println(i);
    }
}
