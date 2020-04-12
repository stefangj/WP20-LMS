package mk.ukim.finki.wp.lms.wpproject.Controller;

import java.util.List;

import mk.ukim.finki.wp.lms.wpproject.Model.Category;
import mk.ukim.finki.wp.lms.wpproject.Model.Issue;
import mk.ukim.finki.wp.lms.wpproject.Service.CategoryService;
import mk.ukim.finki.wp.lms.wpproject.Service.IssueService;
import mk.ukim.finki.wp.lms.wpproject.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/issue")
public class IssueController {

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute(name = "memberTypes")
	public List<String> memberTypes() {
		return Constants.MEMBER_TYPES;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.getAllBySort();
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listIssuePage(Model model) {
		model.addAttribute("issue", issueService.getAllUnreturned());
		return "/issue/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newIssuePage(Model model) { 
		return "/issue/form";
	}
	
}
