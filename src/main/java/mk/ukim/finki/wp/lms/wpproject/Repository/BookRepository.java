package mk.ukim.finki.wp.lms.wpproject.Repository;

import mk.ukim.finki.wp.lms.wpproject.Model.Book;
import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findByTag(String tag);
    public List<Book> findByCategory(Category category);
    public List<Book> findByCategoryAndStatus(Category category, Integer status);
    public Long countByStatus(Integer status);
}
