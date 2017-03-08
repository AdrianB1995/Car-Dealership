//***************************************************//
// Adrian Borrego  U20562120  12/04/15  Car.java     //
//                                                   //
// Car.java file that gives the basic structure      //
// to the car objects.                               //
//                                                   //
//***************************************************//


import java.text.NumberFormat;
import java.util.Random;

public class Car {
	static Random gen = new Random(System.currentTimeMillis());
	// private variables
	private static int modelType;
	private static double cost;
	
	// Constructor with a given type as a parameter
	public Car (int model){
		Car.setType(model);
		Car.cost = gen.nextInt((int) 25001.00) + 5000.00;
	}
	
	// getters
	// Get Type
	public static int getType(){
		return modelType;
	}
	// Get Cost
	public static int getCost(){
		return (int) cost;
	}
	//setters
	//Set Type
	public static void setType(int type){
		modelType = type;
	}
	//Set Cost
	public static void setCost(int model_cost){
		if(model_cost > 5000 && model_cost < 30000){
			cost = model_cost;
		}
	}
	
	// Override the toString method
	public String toString(){
		String carInfo = "";
		carInfo = "\nType: " + modelType + " Cost: " + cost;
		return carInfo;
	}
	
}// end class