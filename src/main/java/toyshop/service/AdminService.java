package toyshop.service;

import java.util.Map;

import toyshop.model.Toy;

public interface AdminService {

	void deleteToy(int id);
	void updateToy(Map<String, String> map);
	Toy addToy(Map<String, String> toy);
}
