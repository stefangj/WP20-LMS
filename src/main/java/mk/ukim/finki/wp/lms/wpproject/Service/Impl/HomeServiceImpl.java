package mk.ukim.finki.wp.lms.wpproject.Service.Impl;

import mk.ukim.finki.wp.lms.wpproject.Service.BookService;
import mk.ukim.finki.wp.lms.wpproject.Service.CategoryService;
import mk.ukim.finki.wp.lms.wpproject.Service.HomeService;
import mk.ukim.finki.wp.lms.wpproject.Service.MemberService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    private final MemberService memberService;
    private final CategoryService categoryService;
    private final BookService bookService;

    public HomeServiceImpl(MemberService memberService, CategoryService categoryService, BookService bookService) {
        this.memberService = memberService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public Map<String, Long> getTopTilesMap() {
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("totalMembers", memberService.getTotalCount());
        map.put("totalStudents", memberService.getStudentsCount());
        map.put("totalParents", memberService.getParentsCount());
        map.put("totalCategories", categoryService.getTotalCount());
        map.put("totalBooks", bookService.getTotalCount());
        map.put("totalIssuedBooks", bookService.getTotalIssuedBooks());
        return map;
    }
}
