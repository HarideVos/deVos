package com.homework;

public class Table extends Product {


    private double height;
    private double width;
    private double length;

    // Constructor
    public Table(int id, String name, double price, double height, double width, double length) {
    	super(id, name, price);
        this.height = height;
        this.width = width;
        this.length = length;
    }

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
    // Method to calculate the area of the table
    public double calculateArea() {
        return width * length;
    }

    // Method to calculate the volume of the table
    public double calculateVolume() {
        return width * length * height;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Table(" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ')';
    }

    // Override equals method to compare two objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Table table = (Table) obj;
        return id == table.id &&
                Double.compare(table.length, length) == 0 &&
                Double.compare(table.height, height) == 0 &&
                Double.compare(table.width, width) == 0;
    }
    public void checkTotalSales() {
        System.out.println("Checking total sales of table...");
    }
}

