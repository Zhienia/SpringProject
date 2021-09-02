package onlineShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import onlineShop.dao.LaptopDAO;

@Controller
@RequestMapping("/laptops")
public class LaptopsController {

	@Autowired
	private LaptopDAO laptops;
	
	@GetMapping()
	public String laptopPage(Model model) {
		System.out.println("Laptop page");
		model.addAttribute("laptops", laptops.getAllLaptops());
		return "laptops";
	}
	
	@GetMapping("/laptop{id}")
	public String laptopEnter(@PathVariable("id") int id, Model model) {
		model.addAttribute("laptops", laptops.getLaptopById(id));
		System.out.print("laptop page");
		return "laptop";
	}
}
