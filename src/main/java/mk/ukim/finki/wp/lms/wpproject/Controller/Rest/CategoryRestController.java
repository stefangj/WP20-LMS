package mk.ukim.finki.wp.lms.wpproject.Controller.Rest;

import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import mk.ukim.finki.wp.lms.wpproject.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/", "/list"})
    public List<Category> all() {
        return categoryService.getAll();
    }
}
