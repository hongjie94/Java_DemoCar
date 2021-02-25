
import java.util.Scanner;

public interface UserInput {
	
	public default float getFloat(String myScanner) {
		return Float.parseFloat(this.getString(myScanner));
	}
	public default boolean getBoolean(String myScanner) {
		return (getString(myScanner + " (Y for Yes)\n").toUpperCase().contains("Y"));
	}
	
	public default String getString(String myScanner) {
		String response = "";
		Scanner input = new Scanner(System.in);
		System.out.print(myScanner);
		response = input.nextLine();
		return response;
	}
	
}
