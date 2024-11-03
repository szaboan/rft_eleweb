package model.entity;

import java.util.List;

public class Customer {
    private Long id;                // Egyedi azonosító
    private String name;            // Ügyfél neve
    private String email;           // Ügyfél e-mail címe
    private String phoneNumber;     // Telefonszám
    private String address;         // Szállítási cím
    private List<Order> orders;     // Ügyfélhez tartozó rendelések listája
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
}
