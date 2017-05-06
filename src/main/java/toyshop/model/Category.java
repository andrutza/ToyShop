package toyshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Toy
	@OneToMany(mappedBy="category")
	private List<Toy> toys;

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Toy> getToys() {
		return this.toys;
	}

	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}

	public Toy addToy(Toy toy) {
		getToys().add(toy);
		toy.setCategory(this);

		return toy;
	}

	public Toy removeToy(Toy toy) {
		getToys().remove(toy);
		toy.setCategory(null);

		return toy;
	}

}