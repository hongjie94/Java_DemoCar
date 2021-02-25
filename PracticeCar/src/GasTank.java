
public class GasTank extends CarPart {

	private float gasMPG;
	private float totalGallon;
	
	
	// GasTank Constructor
	public GasTank(float totalGallon, float gasMPG) {
		super("Gas Tank", "Gallons Gas", totalGallon);
		this.gasMPG = gasMPG;
		this.totalGallon = totalGallon;
	}
	

	// Setter - Refill Gas
	public void setGas(float amountRefill) {
		float usedGas = this.fixedCondition;
		float remaining = (this.defaultCondition - this.fixedCondition); 
		float toalAmountRefill = 0;
		
		if (amountRefill < 0) {
			do {
				
				this.message("Invaild amount of gas. Try again!" );
				this.setGas(getFloat("How many gallons would you like to add?\n"));
				}while(amountRefill > 0);
			
		} else if (amountRefill > usedGas) {
			
			do {
				this.message("Too much Gas! max amount adding " + String.format("%.2f",usedGas) 
				+ " gallons to reach capacity. Try again!");
				float newAmountRefill= getFloat("How many gallons would you like to add?\n");
				amountRefill = 0;
				toalAmountRefill = amountRefill + newAmountRefill;
				if(toalAmountRefill <= usedGas) {
					this.setGas(toalAmountRefill);
				}
				}while(toalAmountRefill > usedGas);
			
		} else {
			float newRemaining = remaining + amountRefill;
			this.message("Adding " + amountRefill + " gallons. You now have "+
			String.format("%.2f", newRemaining) + " gallons.");
			this.setFixedCondition(-1 * amountRefill);
		}
	}
	
	// Getter - Get remaining gas
	public float getGas() {
		return this.defaultCondition - this.fixedCondition;
	}
	
	public void function(float milesDriven) throws VehicleStoped{
		float totalRange = this.totalGallon * this.gasMPG;
		float userRange = 0;
		
		if (milesDriven > totalRange) {
			do {
				this.message("Your max range are " + totalRange + " miles");
				milesDriven =0;
				float Range = getFloat("Please enter the distance(miles) of your destination\n");
				userRange = userRange + Range;
			}while(userRange > totalRange);
		}
		
		userRange = userRange + milesDriven;
		super.function(milesDriven);
		float gasUsed = userRange / this.gasMPG;
		this.setFixedCondition(gasUsed);
		float remaining = (this.defaultCondition - this.fixedCondition); 
		float percentage = ((remaining/this.defaultCondition)*100);
		
		if (remaining <= 0) {
			this.message("Running out of gas! Your Vehicle will now stoped!!!");
			this.Stoped();
		}else if ((remaining / this.defaultCondition) < 0.1) {
			this.message(String.format("%.2f", remaining) +" gallons, ("+ String.format("%.2f", percentage) 
			+ "%) of your gas remaining." + " Warining! Your are low on Gas!" );
			if (getBoolean("Refill?")) {
				this.setGas(getFloat("Enter the amount of gallons you like to add?\n"));
			}
		}else if ((remaining / this.defaultCondition) < 0.5) {
			this.message(String.format("%.2f", remaining) + " gallons, (" +String.format("%.2f",percentage) + " % of your gas remaining."+" Your Gas is less than half full!");
			if (getBoolean("Refill?")) {
				this.setGas(getFloat("Enter the amount of gallons you like to add?\n"));
			}
		}
	}
}
