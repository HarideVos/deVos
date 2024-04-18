package com.homework;

public class Light extends Product {

    private int watts;
    private int lumens;

	public int getWatts() {
		return watts;
	}

	public void setWatts(int watts) {
		this.watts = watts;
	}

	public int getLumens() {
		return lumens;
	}

	public void setLumens(int lumens) {
		this.lumens = lumens;
	}
    // Constructor
    public Light(int id, String name, double price, int watts, int lumens) {
    	super(id, name, price);
        this.watts = watts;
        this.lumens = lumens;
    }

    // Method to check power utilization
    public void checkPowerUtil() {
        double amps = watts / 120.0; // Assuming standard voltage of 120V
        System.out.println("The number of amps used by the light: " + amps);
    }

    // Override toString method 
    @Override
    public String toString() {
        return "Light(" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", watts=" + watts +
                ", lumens=" + lumens +
                ')';
    }

    // Override equals method to compare two objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Light light = (Light) obj;
        return id == light.id &&
                watts == light.watts &&
                lumens == light.lumens;
    }
    public void checkTotalSales() {
        System.out.println("Checking total sales of light bulbs...");
    }
}
