package mk.ukim.finki.wp.lms.wpproject.Service.Impl;

import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import mk.ukim.finki.wp.lms.wpproject.Repository.CategoryRepository;
import mk.ukim.finki.wp.lms.wpproject.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Long getTotalCount() {
        return categoryRepository.count();
    }

    @Override
    public List<Category> getAllBySort() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category addNew(Category category) {
        category.setCreateDate(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean hasUsage(Category category) {
        return category.getBooks().size()>0;
    }
}
