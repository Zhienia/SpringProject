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

import onlineShop.dao.MobileDAO;
import onlineShop.models.Mobile;

@Controller
@RequestMapping("/adminMob")
public class AdminMobileController {

	@Autowired
	private MobileDAO mobiles;

	
	@GetMapping("/mobiles") 
	public String allMobile(Model model) {
	 model.addAttribute("mobiles", mobiles.getAllMobiles()); 
	 return "admin/adminAllMobiles"; 
	 }
	 

	@DeleteMapping("/deleteMobile{id}")
	public String deleteMobile(@PathVariable("id") int id, Model model) {
		mobiles.deleteMobile(id);
		return "redirect:/adminMob/mobiles";
	}

	@GetMapping("/addMobile")
	public String newMobile(Model model) {
		model.addAttribute("mobile", new Mobile());
		return "admin/addMobile";
	}

	@PostMapping()
	public String createMobile(@ModelAttribute("mobile") Mobile mobile) {
		mobiles.createMobile(mobile);
		return "redirect:/adminMob/mobiles";
	}

	@GetMapping("/update{id}")
	public String update(Model model, @PathVariable("id") int id) {
		model.addAttribute("mobile", mobiles.getMobileById(id));
		return "admin/updateMobile";
	}

	@PatchMapping("/updateMobile{id}")
	public String updateMobile(@ModelAttribute("mobile") Mobile mobile, @PathVariable("id") int id) {
		mobiles.updateMobile(mobile, id);
		return "redirect:/adminMob/mobiles";
	}
}
