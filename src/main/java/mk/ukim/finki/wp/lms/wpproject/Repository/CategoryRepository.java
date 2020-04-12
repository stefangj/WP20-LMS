package mk.ukim.finki.wp.lms.wpproject.Repository;

import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findAllByOrderByNameAsc();
}
