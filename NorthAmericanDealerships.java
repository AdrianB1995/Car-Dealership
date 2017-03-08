import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class NorthAmericanDealerships {
	public static void main(String[] args) {
		int max = 7;
		int day = 0;
		Random gen = new Random(System.currentTimeMillis());
		double sellRate = .30;
		ArrayList<Dealership> dealers = new ArrayList<Dealership>();
		dealers.add(new Dealership("Brandon Ford"));
		dealers.add(new Dealership("Tampa Honda"));
		dealers.add(new Dealership("Hillsboro Auto Mart, Inc."));
		while (day < max) {
			for (int i = 0; i < dealers.size(); i++) {
				if (gen.nextDouble() < sellRate) {
					dealers.get(i).sellACar();
				}
			}
			day++;
		}
		double average = 0.0;
		// Add code to get the average totals of all the Dealerships.
		for(int i = 0; i < dealers.size(); i++){
			average += dealers.get(i).getAverageCost();
		}
		NumberFormat f = NumberFormat.getCurrencyInstance();
		System.out.println("Dealership Totals Average " + f.format(average) + "\n");
		// print each dealership
		for (int i = 0; i < dealers.size(); i++) {
			System.out.println(dealers.get(i));
			System.out.println(dealers.get(i).toStringSoldCars() + "\n");
		}
	}// end main
}// end class