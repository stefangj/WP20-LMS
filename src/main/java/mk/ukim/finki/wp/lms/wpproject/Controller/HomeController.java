package mk.ukim.finki.wp.lms.wpproject.Controller;

import mk.ukim.finki.wp.lms.wpproject.Service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	private final HomeService homeService;

	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("topTiles", homeService.getTopTilesMap());
		return "home";
	}	
	
}
