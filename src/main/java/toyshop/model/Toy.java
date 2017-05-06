package toyshop.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the toy database table.
 * 
 */
@Entity
@NamedQuery(name="Toy.findAll", query="SELECT t FROM Toy t")
public class Toy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int count;

	private String description;

	private String name;

	private Integer price;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	public Toy() {
	}

	public Toy(int count) {
		this.count = count;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}