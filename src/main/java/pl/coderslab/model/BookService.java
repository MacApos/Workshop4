package pl.coderslab.model;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();

    Optional<Book> get(Long id) throws Exception;

    void add(Book book) throws Exception;

    void delete(Long id) throws Exception;

    void update(Book book) throws Exception;
}

