package toyshop.repository;

import java.util.List;

import toyshop.model.Category;
import toyshop.model.Toy;

public interface SellerRepository {

	List<Category> findCategories();
	List<Toy> findToysByCategoryId(int id);
	Toy update(Toy toy);

}
