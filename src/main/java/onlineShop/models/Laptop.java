package onlineShop.models;

public class Laptop {
	
	private int id;
	private String manufacturer;
	private String model;
	private double screen;
	private int ram;
	private double processor;
	private int ramGpu;
	private int countUsb;
	private double cost;
	
	public Laptop() {
		
	}
	
	public Laptop(int id, String manufacturer, String model, double screen, int ram, double processor, int ramGpu, int countUsb, double cost) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.screen = screen;
		this.ram = ram;
		this.processor = processor;
		this.ramGpu = ramGpu;
		this.countUsb = countUsb;
		this.cost = cost;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setScreen(double screen) {
		this.screen = screen;
	}
	
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public void setProcessor(double processor) {
		this.processor = processor;
	}
	
	public void setRamGpu(int ramGpu) {
		this.ramGpu = ramGpu;
	}
	
	public void setCountUsb(int countUsb) {
		this.countUsb = countUsb;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public double getScreen() {
		return screen;
	}
	
	public int getRam() {
		return ram;
	}
	
	public double getProcessor() {
		return processor;
	}
	
	public int getRamGpu() {
		return ramGpu;
	}
	
	public int getCountUsb() {
		return countUsb;
	}
	
	public double getCost() {
		return cost;
	}
}
