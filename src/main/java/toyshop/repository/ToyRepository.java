package toyshop.repository;

import java.util.List;
import java.util.Map;

import toyshop.model.Category;
import toyshop.model.Toy;

public interface ToyRepository {

	List<Category> findCategories();
	List<Toy> findToysByCategoryId(int id);
	Toy updateCount(Toy toy);
	List<Toy> getToys();
	Toy addToy(Toy toy);
	Category findCategoryById(int id);
	void deleteToy(int id);
	void update(Map<String, String> data);

}
