package toyshop.controller;

import java.util.HashMap;
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
import toyshop.service.AdminService;

@RestController
@RequestMapping(value="/admin")
public class AdminController {

	
	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/toys", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseStatus(value=HttpStatus.OK)
	public Map<String, Toy> addToy(@RequestBody Map<String, String> toy) {
		Toy newToy = adminService.addToy(toy);
		Map<String, Toy> result = new HashMap<>();
		result.put("result", newToy);
		return result;
	}
	
	@RequestMapping(value="/toys/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteToy(@PathVariable int id) {
		adminService.deleteToy(id);
	}
	
	@RequestMapping(value="/toys/{id}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.OK)
	public void updateToy(@PathVariable int id, @RequestBody Map<String, String> data) {
		data.put("id", id+"");
		adminService.updateToy(data);
	}
}
