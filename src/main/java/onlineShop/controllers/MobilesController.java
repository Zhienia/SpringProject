package onlineShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import onlineShop.dao.MobileDAO;

@Controller
@RequestMapping("/admin/mobiles")
public class MobilesController {

	@Autowired
	private MobileDAO mobiles;
	
	@GetMapping()
	public String mobilePage(Model model) {
		System.out.println("Mobile page");
		model.addAttribute("mobiles", mobiles.getAllMobiles());
		return "mobiles";
	}
	
	@GetMapping("/mobile{id}")			
	public String mobileEnter(@PathVariable("id") int id, Model model) {
		model.addAttribute("mobiles", mobiles.getMobileById(id));
		return "mobile";
	}
}
