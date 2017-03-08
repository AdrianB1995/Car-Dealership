//***************************************************//
// Adrian Borrego  U20562120  12/04/15               //
//                                                   //
// Dealership.java file that gives the basic         //
// structure to the car objects.                     //
//                                                   //
//***************************************************//

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Dealership {
	final int numModels = 5;
	int[] modelsCount = new int[numModels];
	ArrayList<Car> carsSold = new ArrayList<Car>();
	Random gen = new Random(System.currentTimeMillis());

	// private variables
	private String dealershipName;
	private int dealershipID;
	private static int nextID = 1;
	private double totalSales;
	private int commonSaleModel;
	private double average_Sold_Cost;
	
	// Constructor with a name as a parameter
	public Dealership (String dealershipName){
		this.dealershipName = dealershipName;
		dealershipID = nextID++;
		totalSales = 0;
		commonSaleModel = 0;
		average_Sold_Cost = 0;
		
	}
	
	/*
	 * Sell Car - This method will create a random car object and add it to the
	 * ArrayList using the add method.
	 */
	public void sellACar() {
		int type = gen.nextInt(numModels);// 0 to 5
		carsSold.add(new Car(type));
		modelsCount[type]++;
	}

	// Get the total cost of all the cars by add the cost of each car
	// Add code here
	public double getTotalSales() {
		double total = 0.0;
		for(int i = 0; i < carsSold.size(); i++){
			total += Car.getCost();
		}
		
		totalSales = total;
		return totalSales;
	}

	// Get the average cost of each car by getting the totalSales
	// and dividing by the size() of the arrayList carsSold
	// Add code here
	public double getAverageCost(){
		return this.average_Sold_Cost = getTotalSales() / carsSold.size();
	}
	
	// Get the most common model
	// Add code here
	public int getCommonModel(){
		for(int i = 0; i < numModels; i++){
			if(modelsCount[i] > modelsCount[commonSaleModel])
				commonSaleModel = i;
		}
		return this.commonSaleModel;
	}
	
	// Print all the sold cars
	public String toStringSoldCars() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < this.carsSold.size(); i++) {
			result.append(this.carsSold.get(i));
		}
		return result.toString();
	}
	// override toString method
	public String toString(){
		String dealershipInfo = "";
		dealershipInfo = "ID: " + dealershipID + " " + dealershipName + "\nCars Sold: " + carsSold.size()
							+ "\nTotal Sales: " + getTotalSales() + "\nAverage Cost: " + getAverageCost() 
							+ "\nMost Common Model: " + getCommonModel();
		return dealershipInfo;
	}
}