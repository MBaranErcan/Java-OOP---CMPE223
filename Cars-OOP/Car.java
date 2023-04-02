package free01;

public class Car {
		
	private String color;
	private String model;
	private	double engine;
	private int doors;
	
	public Car(String color, String model) {
		this(color, model, 0.0, 0);
	}
	
	public Car() {
		this("Bilgi Yok" ,"Bilgi Yok" ,0.0 ,0); 
	}
	
	public Car(String color, String model, double engine, int doors) {
		this.color = color;
		this.model = model;
		this.engine = engine;
		this.doors = doors;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public String getModel() {
		return this.model;
	}
	
	
	public void setEngine(double engine) {
		this.engine = engine;
	}
	
	
	public double getEngine() {
		return this.engine;	
	}
	
	
	public void setDoors(int doors) {
		if(doors == 2 || doors == 4) {
			this.doors = doors;
		}
		else {
			System.out.println("Kapý sayýsý sadece 2 veya 4 olabilir!");
		}
	}
	
	public void showInfos() {
		System.out.println("Arabanýn Rengi: " + this.color);
		System.out.println("Arabanýn Modeli: " + this.model);
		System.out.println("Arabanýn Motor Hacmi: " + this.engine);
		System.out.println("Arabanýn Kapý Sayýsý: " + this.doors);
	}
	
	
	
	public int getDoors() {
		return this.doors;
	}
	
	
}
