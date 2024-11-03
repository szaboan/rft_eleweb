package model.entity;

public class Product {
	private Long id;               // Egyedi azonosító
    private String name;           // Termék neve
	private String description;     // Termék leírása
	private double price;           // Termék ára
	private int stockQuantity;      // Raktáron lévő mennyiség
	private Category category;      // Termék kategóriája (kapcsolat a Category osztállyal)
	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = (long) id;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
