package mk.ukim.finki.wp.lms.wpproject.Service;

import mk.ukim.finki.wp.lms.wpproject.Model.Category;

import java.util.List;

public interface CategoryService {
    Long getTotalCount();
    List<Category> getAllBySort();
    List<Category> getAll();
    Category get(Long id);
    Category addNew(Category category);
    Category save(Category category);
    void delete(Category category);
    void delete(Long id);
    boolean hasUsage(Category category);
}
