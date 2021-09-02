package onlineShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import onlineShop.dao.LaptopDAO;
import onlineShop.models.Laptop;

@Controller
@RequestMapping("/adminLap")
public class AdminLaptopController {
	
	@Autowired
	private LaptopDAO laptops;
	
	@GetMapping("/laptops")
	public String allLaptops(Model model) {
		model.addAttribute("laptops", laptops.getAllLaptops());
		return "admin/adminAllLaptops";
	}
	
	@GetMapping("/addLaptop")
	public String addLaptop(Model model) {
		model.addAttribute("laptop", new Laptop());
		return "admin/addLaptop";
	}
	
	@PostMapping
	public String createLaptop(@ModelAttribute("laptop") Laptop laptop) {
		laptops.createLaptop(laptop);
		return "redirect:/adminLap/laptops";
	}
	
	@DeleteMapping("/deleteLaptop{id}")
	public String deleteLaptop(@PathVariable("id") int id) {
		laptops.deleteLaptop(id);
		return "redirect:/adminLap/laptops";
	}
	
	@GetMapping("/update{id}")
	public String update(Model model, @PathVariable("id") int id) {
		model.addAttribute("laptop", laptops.getLaptopById(id));
		return "admin/updateLaptop";
	}
	
	@PatchMapping("/updateLaptop{id}")
	public String updateLaptop(@ModelAttribute("laptop") Laptop laptop, @PathVariable("id") int id) {
		laptops.updateLaptop(laptop, id);
		return "redirect:/adminLap/laptops";
	}
}
