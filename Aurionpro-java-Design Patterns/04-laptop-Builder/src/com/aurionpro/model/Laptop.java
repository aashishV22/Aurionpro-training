package com.aurionpro.model;

 class Laptop implements IGadgets{
	private int id;
	private String brand;
	private String hdd;
	private String ram;
	private boolean touchScreen;
	private String processor;
	
	public Laptop() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public boolean isTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(boolean touchScreen) {
		this.touchScreen = touchScreen;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", hdd=" + hdd + ", ram=" + ram + ", touchScreen="
				+ touchScreen + ", processor=" + processor + "]";
	}
	
	
}
