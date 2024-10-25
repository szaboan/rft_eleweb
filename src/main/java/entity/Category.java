package entity;

import java.util.List;

public class Category {
    private Long id;                   // Egyedi azonosító
    private String name;               // Kategória neve
    private String description;        // Kategória leírása
    private List<Product> products;    // Kategóriához tartozó termékek listája
    private Category parentCategory;   // Főkategória (hierarchikus felépítés esetén)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
    
}
