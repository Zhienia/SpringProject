package onlineShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomePageController {
	
	@GetMapping()
	public String homePage() {
		System.out.println("Home page");
		return "homePage";
	}
	
//	@GetMapping("/mobile")
//	public String mobilePage(@RequestParam(value = "namePageMobile", required = false) String namePageMobile) {
//		return "mobile";
//	}
	
}