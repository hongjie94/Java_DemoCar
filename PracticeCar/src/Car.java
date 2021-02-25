
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Car implements UserInput{
	
	// Save all Car parts in an ArrayList
	private ArrayList<CarPart> CarParts = new ArrayList<>();
	
	
	// Car Constructor
	public Car() {
		
		// 18.1 miles per gallons
		float MPG = 18.1f;
		
		// Total gas capacity 17.30 gallons (18.1 miles per gallons)
		this.CarParts.add(new GasTank(17.30f, MPG));
		
		// Total range 313.13 miles 
		this.CarParts.add(new Range(313.13f, MPG));
		
		// Total Brakes Condition 100 (Starting with 0 condition wear)
		this.CarParts.add(new Brakes(100f, 0));

		// Engine = 10 (Starting 0 life spend)
		this.CarParts.add(new Engine(10, 0));

	}
	
	public void status() {
		for (Iterator<CarPart> iter = this.CarParts.iterator(); iter.hasNext();) {
			iter.next().status();
		}
	}
	
	public void run() {
		try {
			do {
				float miles = getFloat("Please enter the distance(miles) of your destination\n");
				
				GasTank gasTank = null;
				gasTank = (GasTank) CarParts.get(0);
				
				Range range = null;
				range = (Range) CarParts.get(1);
				
				for (int p = 0; p<CarParts.size(); p++) {
					CarParts.get(p).function(miles);
				}

				range.getRange(gasTank.getGas());
				
				// Update range
				range.setRange(gasTank.getGas());
				this.status();
				
			}while(getBoolean("Keep Driving?"));
		} catch (VehicleStoped e) {
			e.printStackTrace();
		}finally {
			System.out.println("Thanks for Driving!");
		}
	}
}
	


	
