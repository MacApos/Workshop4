package pl.coderslab.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MockBookService implements BookService {
    private List<Book> list;

    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public Long getNextId() {
        return nextId;
    }


    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) throws Exception {
        return Optional.ofNullable(list.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst().orElseThrow(() -> new Exception("Book not found")));
    }

    @Override
    public void add(Book book) {
        list.add(book);
        nextId += 1L;
    }

    @Override
    public void delete(Long id) throws Exception {
        if (get(id).isPresent()) {
            this.list = list.stream()
                    .filter(book -> !book.getId().equals(id))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void update(Book book) throws Exception {
        Optional<Book> bookToUpdate = get(book.getId());
        if (bookToUpdate.isPresent()) {
            int i = list.indexOf(bookToUpdate.get());
            list.set(i, book);
        }
    }
}

