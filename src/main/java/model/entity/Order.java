package model.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;                     // Egyedi azonosító
    private Customer customer;           // Rendelő ügyfél (kapcsolat a Customer osztállyal)
    private LocalDateTime orderDate;     // Rendelés dátuma és ideje
    private double totalAmount;          // Teljes összeg
    private String status;               // Rendelés állapota (pl. feldolgozás alatt, szállítás alatt, kézbesítve)
    private List<Product> products;      // Rendeléshez tartozó termékek listája
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
}
