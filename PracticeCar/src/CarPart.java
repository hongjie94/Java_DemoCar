
// Implement a Functional interface, which declares a method "function()".
public abstract class CarPart implements Functional, UserInput {
	
	// Access to current package only
	protected String partName;
	protected String measurement;
	protected float defaultCondition;
	protected float fixedCondition;
	protected float percentage;
	protected float currentTotalMiles;
	protected float changeCondition;
	
	// CarPart Constructor
	public CarPart(String partName, String measurement, float defaultCondition) {
		this.partName = partName;
		this.defaultCondition = defaultCondition;
		this.measurement = measurement;
		this.fixedCondition = 0;
		this.currentTotalMiles = 0;
		this.changeCondition = 0;
	}
	
	// Getters
	public void getCurrentTotalMiles(float milesDriven) {
		this.currentTotalMiles += milesDriven;
	}
	
	public float getDefaultCondition() {return this.defaultCondition;}
	public float getFixedCondition() {return this.fixedCondition;}
	

	// Setters
	public void setFixedCondition(float newCondition) {
		this.fixedCondition += newCondition;
		
		// Void negative
		if (this.fixedCondition < 0 ) {
			this.fixedCondition =0;
			
		// Void passing defaultCondition	
		}else if (this.fixedCondition > this.defaultCondition) {
			this.fixedCondition = this.defaultCondition;
		}
		
	}
	
	
	public void setChangeCondition(float change) {
		this.fixedCondition += change;
		if (this.fixedCondition < this.defaultCondition) {
			
		}
	}
	
	// Broken part set condition to 0
	public void partBroken() {
		if(this.defaultCondition - this.fixedCondition == 0) {
			message(this.partName + "in bad condition!");
		}
	}
	
	public void replacePart() {
		this.fixedCondition = 0;
		message("Your "+this.partName + " has been replace you are good to go!");
	}
	
	
	public void Stoped() throws VehicleStoped {
		throw new VehicleStoped("Your Vehicle stop running! Please check your " + this.partName + " !");
	}
	
	public void status() {
		float remaining = (this.defaultCondition - this.fixedCondition);
		float percentage = (remaining/this.defaultCondition)*100;
		System.out.println(this.partName +": " + String.format("%.2f", remaining) + "/"+ this.defaultCondition 
				+" "+ this.measurement + " ("+ String.format("%.2f", percentage )+"%)");
	}
	
	public void message(String message) {
		System.out.println(message);
	}
		
	public void function(float milesDriven) throws VehicleStoped {
		this.currentTotalMiles += milesDriven;
	}


	
	
	
	
	

}
