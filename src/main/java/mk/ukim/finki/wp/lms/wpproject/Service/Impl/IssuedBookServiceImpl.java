package mk.ukim.finki.wp.lms.wpproject.Service.Impl;

import mk.ukim.finki.wp.lms.wpproject.Model.Book;
import mk.ukim.finki.wp.lms.wpproject.Model.IssuedBook;
import mk.ukim.finki.wp.lms.wpproject.Repository.IssuedBookRepository;
import mk.ukim.finki.wp.lms.wpproject.Service.IssuedBookService;
import mk.ukim.finki.wp.lms.wpproject.common.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedBookServiceImpl implements IssuedBookService {

    private final IssuedBookRepository issuedBookRepository;

    public IssuedBookServiceImpl(IssuedBookRepository issuedBookRepository) {
        this.issuedBookRepository = issuedBookRepository;
    }

    @Override
    public List<IssuedBook> getAll() {
        return issuedBookRepository.findAll();
    }

    @Override
    public IssuedBook get(Long id) {
        return issuedBookRepository.findById(id).get();
    }

    @Override
    public Long getCountByBook(Book book) {
        return issuedBookRepository.countByBookAndReturned(book, Constants.BOOK_NOT_RETURNED);
    }

    @Override
    public IssuedBook save(IssuedBook issuedBook) {
        return issuedBookRepository.save(issuedBook);
    }

    @Override
    public IssuedBook addNew(IssuedBook issuedBook) {
        issuedBook.setReturned(Constants.BOOK_NOT_RETURNED);
        return issuedBookRepository.save(issuedBook);
    }
}
