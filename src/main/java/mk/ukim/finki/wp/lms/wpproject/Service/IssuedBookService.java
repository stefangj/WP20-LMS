package mk.ukim.finki.wp.lms.wpproject.Service;

import mk.ukim.finki.wp.lms.wpproject.Model.Book;
import mk.ukim.finki.wp.lms.wpproject.Model.IssuedBook;

import java.util.List;

public interface IssuedBookService {
    List<IssuedBook> getAll();
    IssuedBook get(Long id);
    Long getCountByBook(Book book);
    IssuedBook save(IssuedBook issuedBook);
    IssuedBook addNew(IssuedBook issuedBook);

}
