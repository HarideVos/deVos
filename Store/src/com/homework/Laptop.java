package com.homework;
import java.util.Objects;

public class Laptop extends Product {

	private double screenSize;
    private int RAM;
    private int SSD;
    private String processor;

    public Laptop(int id, String name, double price, double rating, double screenSize, int RAM, int SSD, String processor) {
        super(id, name, price, rating);
        this.screenSize = screenSize;
        this.RAM = RAM;
        this.SSD = SSD;
        this.processor = processor;
    }
    public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public int getSSD() {
		return SSD;
	}

	public void setSSD(int sSD) {
		SSD = sSD;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

    // Method to check if the laptop is charging
    public void checkCharging() {
        System.out.println("Checking if laptop is charging...");
    }

    // Method to check if someone is logged into the laptop
    public void checkLogin() {
        System.out.println("Checking if someone is logged into the laptop...");
    }
    // Override toString method
    @Override
    public String toString() {
        return "Laptop(" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", screenSize=" + screenSize +
                ", RAM=" + RAM +
                ", SSD=" + SSD +
                ", processor='" + processor + '\'' +
                ')';
    }

    // Override equals method to compare two objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id == laptop.id &&
                RAM == laptop.RAM &&
                SSD == laptop.SSD &&
                Double.compare(laptop.price, price) == 0 &&
                Double.compare(laptop.screenSize, screenSize) == 0 &&
                Objects.equals(name, laptop.name) &&
                Objects.equals(processor, laptop.processor);
    }
}
