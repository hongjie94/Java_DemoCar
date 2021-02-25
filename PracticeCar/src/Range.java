
public class Range extends CarPart{
	
	private float rangeMPG;
	private float totalRange;
	
	// Range Constructor
	public Range(float totalRange, float rangeMPG) {
		super("Range", "Miles", totalRange);
		this.rangeMPG = rangeMPG;
		this.totalRange = totalRange;
	}
	
	// Getter - get available Range(miles)
	public float getRange(float remainGas) {
		return remainGas * this.rangeMPG;
	}
	
	public float getTotalMiles() {
		return this.currentTotalMiles;
	}
	
	
	public void setRange(float remainGas) {
		float rangeBaseGas =  this.rangeMPG * remainGas;
		float newRagnge = this.totalRange - rangeBaseGas;
		this.fixedCondition = 0;
		this.setFixedCondition(newRagnge);
		System.out.println("Total miles traveled "+this.currentTotalMiles + " miles");
	}
	
	public void function(float milesDriven) throws VehicleStoped{
		super.function(milesDriven);
	}

}
