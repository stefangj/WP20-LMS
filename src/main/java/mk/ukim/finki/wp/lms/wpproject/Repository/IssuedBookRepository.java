package mk.ukim.finki.wp.lms.wpproject.Repository;

import mk.ukim.finki.wp.lms.wpproject.Model.Book;
import mk.ukim.finki.wp.lms.wpproject.Model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {
    public Long countByBookAndReturned(Book book, Integer returned);

}
