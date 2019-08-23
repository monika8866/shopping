package com.monika.DynamicFrontEnd.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monika.DAO.CategoryDAO;
import com.monika.DAO.ProductDAO;
import com.monika.DAO.UserDAO;
import com.monika.Model.Address;
import com.monika.Model.User;

@Controller
public class HomeController {
	

	@Autowired // Spring
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/category/All" })
	public String Home(Model model) {
		model.addAttribute("userClickHome", true);
		// model.addAttribute("categories", categoryDAO.list());
		model.addAttribute("products", productDAO.listActiveProducts());// hibernate by product dao

		return "index";
	}

	@RequestMapping("/category/{id}")
	public String filterByCategory(@PathVariable("id") int id, Model model) {

		model.addAttribute("userClickHome", true);
		// model.addAttribute("categories", categoryDAO.list());
		model.addAttribute("products", productDAO.listActiveProductsByCategory(id));// hibernate by product dao

		return "index";
	}

	@RequestMapping("/register")
	public String register(@RequestParam(value = "error", required = false) String errCode, Model model) {
		if (errCode != null) {
			switch (errCode) {
			case "1":
				model.addAttribute("msg", "User Email Already Present");
				break;
			case "2":
				model.addAttribute("msg", "Password and Confirm Password do not match !");
				break;
			}
		}

		model.addAttribute("userClickRegister", true);
		// model.addAttribute("categories", categoryDAO.list());
		model.addAttribute("user", new User());// hibernate by product dao

		return "index";
	}

	// @RequestMapping(value="/register",method = RequestMethod.POST)
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") User user, Model model) {

		
		
		if (userDAO.getByEmail(user.getEmail()) != null) {
			return "redirect:/register?error=1";
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			return "redirect:/register?error=2";
		}
		user.setRole("USER");
		userDAO.add(user);

		model.addAttribute("userClickSaveUser", true);
		// model.addAttribute("categories", categoryDAO.list());
		Address address = new Address();

		address.setUserId(user.getId());

		model.addAttribute("address", address);// hibernate by product dao

		return "index";
	}

	@PostMapping("/address")
	public String saveUser(@ModelAttribute("address") Address address, Model model) {

		address.setBilling(true);
		userDAO.addAddress(address);

		return "redirect:/login";
	}

}
