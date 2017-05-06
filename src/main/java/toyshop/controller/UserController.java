package toyshop.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import toyshop.model.Category;
import toyshop.model.User;
import toyshop.service.SellerService;


@Controller
@RequestMapping("/")
public class UserController {

	private SellerService sellerService;
	
	@Autowired
	public UserController(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	
	@RequestMapping(method=GET)
    public String login(Model model) {
		model.addAttribute(new User());
        return "login";
    }
	
	@RequestMapping(value="/accessDenied", method=GET)
    public String accessDenied() {
        return "accessDenied";
    }
	
	@RequestMapping(value="/seller", method=RequestMethod.GET)
	public String seller(Model model) {
		List<Category> categories = sellerService.findCategories();
        model.addAttribute("categories", categories);
		return "seller";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(Model model) {
		List<Category> categories = sellerService.findCategories();
        model.addAttribute("categories", categories);
        model.addAttribute(sellerService.getToys());
		return "admin";
	}


}
