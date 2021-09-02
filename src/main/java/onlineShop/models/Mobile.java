package onlineShop.models;

public class Mobile {

	private int id;
	private String manufacturer;
	private String model;
	private double screen;
	private int ram;
	private double processor;
	private int camera;
	private double cost;
	
	public Mobile() {
		
	}
	
	public Mobile(int id, String manufacturer, String model, double screen, int ram, double processor, int camera, double cost) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.screen = screen;
		this.ram = ram;
		this.processor = processor;
		this.camera = camera;
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
	
	public void setCamera(int camera) {
		this.camera = camera;
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
	
	public int getCamera() {
		return camera;
	}
	
	public double getCost() {
		return cost;
	}
}
