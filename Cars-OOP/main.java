package free01;

public class main {

	public static void main(String[] args) {
		
		Car car1 = new Car("Mavi","XC60", 1.6,4);
	
		Car car2 = car1;
		
		car1.setColor("Blue");
		
		car1.showInfos();
		
		Car car3 = null;
		car3.showInfos();
		
	}

}
