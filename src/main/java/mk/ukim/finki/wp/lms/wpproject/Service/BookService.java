package mk.ukim.finki.wp.lms.wpproject.Service;

import mk.ukim.finki.wp.lms.wpproject.Model.Book;
import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Long getTotalCount();
    Long getTotalIssuedBooks();
    List<Book> getAll();
    Book get(Long id);
    Book getByTag(String tag);
    List<Book> get(List<Long> ids);
    List<Book> getByCategory(Category category);
    List<Book> getAvailableByCategory(Category category);
    Book addNew(Book book);
    Book save(Book book);
    void delete(Book book);
    void delete(Long id);
    boolean hasUsage(Book book);
}
