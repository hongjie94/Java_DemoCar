
public class Engine extends CarPart{
	
	private float Enginelife;
	
	// Engine Constructor 
	public Engine(float Enginelife, float EnginelifeSpend) {
		super("Engine", " Condition", Enginelife);
		
		this.Enginelife = Enginelife;
	}
	
	// Setters - Set Engine Life
	public void setBrakesCondition(float enginelifeSpend) {
		
		// Engine life starting at 10 (For every 10000 miles Engine life will decrease by 1) 
		this.fixedCondition = 0;
		this.setFixedCondition(enginelifeSpend);
	}
		
	// Replace Engine
	public void replacePart() {
		super.replacePart();
	}
	
	public void function(float milesDriven) throws VehicleStoped{
		super.function(milesDriven);
		float enginelifeSpend = this.currentTotalMiles/10000;
		float EngineCondition = this.Enginelife - enginelifeSpend;
		this.setBrakesCondition(enginelifeSpend);
		if (EngineCondition <= 0) {
			this.Stoped();
		}else if (EngineCondition <= 2) {
			this.message("Warining! Your Engine is getting old !");
			if (getBoolean("Replace?")) {
				this.replacePart();
			}
		}
	}
	
}
