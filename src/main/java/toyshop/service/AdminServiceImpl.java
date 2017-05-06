package toyshop.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import toyshop.model.Category;
import toyshop.model.Toy;
import toyshop.repository.ToyRepository;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {
	
	private ToyRepository toyRepository;
	
	@Autowired
	public AdminServiceImpl(ToyRepository toyRepository) {
		this.toyRepository = toyRepository;
	}
	
	public Toy addToy(Map<String, String> data) {
		Category category = toyRepository.findCategoryById(Integer.parseInt(data.get("category")));
		Toy toy = new Toy();
		toy.setCount(Integer.parseInt(data.get("count")));
		toy.setDescription(data.get("description"));
		toy.setPrice(Integer.parseInt(data.get("price")));
		toy.setName(data.get("name"));
		toy.setCategory(category);
		return toyRepository.addToy(toy);
	}

	@Override
	public void deleteToy(int id) {
		toyRepository.deleteToy(id);
	}

	@Override
	public void updateToy(Map<String, String> map) {
		toyRepository.update(map);
	}

}
