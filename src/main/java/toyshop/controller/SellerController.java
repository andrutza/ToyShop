package toyshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import toyshop.model.Toy;
import toyshop.service.SellerService;

@RestController
@RequestMapping(value="/seller")
public class SellerController {

	private SellerService sellerService;
	
	@Autowired
	public SellerController(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	@RequestMapping(value="/{categoryId}", method=RequestMethod.GET, produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Map<String, List<Toy>> toys(@PathVariable Integer categoryId) {
		Map<String, List<Toy>> toys = new HashMap<>();
		toys.put("list", sellerService.findToysByCategoryId(categoryId));
		return toys;
	}
	
	@RequestMapping(value="/toys", method=RequestMethod.POST, consumes="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public void toys(@RequestBody Map<String, List<Toy>> toys) {
		sellerService.updateCounts(toys.get("list"));
	}

}
