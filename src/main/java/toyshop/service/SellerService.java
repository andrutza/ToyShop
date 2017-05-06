package toyshop.service;

import java.util.List;

import toyshop.model.Category;
import toyshop.model.Toy;

public interface SellerService {

	List<Category> findCategories();
	List<Toy> findToysByCategoryId(int id);
	List<Toy> getToys();
	void updateCounts(List<Toy> toy);

}
