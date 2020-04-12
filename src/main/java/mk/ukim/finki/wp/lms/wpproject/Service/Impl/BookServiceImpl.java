package mk.ukim.finki.wp.lms.wpproject.Service.Impl;

import mk.ukim.finki.wp.lms.wpproject.Model.Book;
import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import mk.ukim.finki.wp.lms.wpproject.Repository.BookRepository;
import mk.ukim.finki.wp.lms.wpproject.Service.BookService;
import mk.ukim.finki.wp.lms.wpproject.Service.IssuedBookService;
import mk.ukim.finki.wp.lms.wpproject.common.Constants;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final IssuedBookService issuedBookService;

    public BookServiceImpl(BookRepository bookRepository, IssuedBookService issuedBookService) {
        this.bookRepository = bookRepository;
        this.issuedBookService = issuedBookService;
    }


    @Override
    public Long getTotalCount() {
        return bookRepository.count();
    }

    @Override
    public Long getTotalIssuedBooks() {
        return bookRepository.countByStatus(Constants.BOOK_STATUS_ISSUED);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book getByTag(String tag) {
        return bookRepository.findByTag(tag);
    }

    @Override
    public List<Book> get(List<Long> ids) {
        return bookRepository.findAllById(ids);
    }

    @Override
    public List<Book> getByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> getAvailableByCategory(Category category) {
        return bookRepository.findByCategoryAndStatus(category, Constants.BOOK_STATUS_AVAILABLE);
    }

    @Override
    public Book addNew(Book book) {
        book.setCreateDate(new Date());
        book.setStatus( Constants.BOOK_STATUS_AVAILABLE );
        return bookRepository.save(book);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public boolean hasUsage(Book book) {
        return issuedBookService.getCountByBook(book)>0;
    }
}
