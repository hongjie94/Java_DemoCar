
public class Brakes extends CarPart  {
	
	private float bestCondition;
	
	public Brakes(float bestCondition, float conditionWear) {
		super("Brake", "Condition", bestCondition);
		
		this.bestCondition = bestCondition;
	}
	
	// Setters - Set Brakes Condition
	public void setBrakesCondition(float conditionWear) {
		
		// Brakes Condition starting at 100 (For every 100 miles  Brakes Condition decrease by 10) 
		this.fixedCondition = 0;
		this.setFixedCondition(conditionWear);
	}
	
	// Replace Brakes
	public void replacePart() {
		super.replacePart();
	}
	
	public void function(float milesDriven) throws VehicleStoped{
		super.function(milesDriven);
		float conditionWear =  ((this.currentTotalMiles/100)*10);
		float BrakesCondition = this.bestCondition - conditionWear;
		this.setBrakesCondition(conditionWear);
		if (BrakesCondition <= 0) {
			this.Stoped();
		}else if (BrakesCondition <= 30) {
			this.message("Warining! Your Brakes are in bad condition !");
			if (getBoolean("Replace?")) {
				this.replacePart();
			}
		}
	}
}
