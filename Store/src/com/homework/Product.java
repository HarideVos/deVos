package com.homework;

public abstract class Product {


	protected int id;
    protected String name;
    protected double price;
    protected double rating;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
    public Product(int id, String name, double price, double rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
	public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
	}
	
    public void checkTotalSales() {
	System.out.println("Total Sales.");
    }
}