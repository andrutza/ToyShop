package toyshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import toyshop.model.Category;
import toyshop.model.Toy;
import toyshop.repository.ToyRepository;

@Transactional
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private ToyRepository toyRepository;

	public List<Category> findCategories() {
		return toyRepository.findCategories();
	}

	public List<Toy> findToysByCategoryId(int id) {
		return toyRepository.findToysByCategoryId(id);
	}

	public void updateCounts(List<Toy> toys) {
		for (Toy toy : toys) {
			toyRepository.updateCount(toy);
		}
	}

	public List<Toy> getToys() {
		return toyRepository.getToys();
	}
}
