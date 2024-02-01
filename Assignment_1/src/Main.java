import java.util.Scanner;

public class Main{
	
	private static final double WEIGHT_MIN_KG = 10;
    private static final double WEIGHT_MAX_KG = 300;
    
	private static final double HEIGHT_MIN_METERS = 0.2;
    private static final double HEIGHT_MAX_METERS = 2.2;
	
	public static void main(String[] args) {
		
		double weight = 0;
		double height = 0;
		String recommendation = "";
		
		Scanner scanner = new Scanner(System.in);

	    System.out.println("---BMI CALCULATOR---");

    	while (weight < WEIGHT_MIN_KG || weight > WEIGHT_MAX_KG) {
    		
    		System.out.print("Enter the weight (in kilograms): ");
    		
    		// Try and Catch to create an Exception Message ensuring the user input is valid (numerical).
    		try {
    			weight = Double.parseDouble(scanner.next()); // scanner returns String, so converting it to Double.
    			
	    		if(weight < WEIGHT_MIN_KG || weight > WEIGHT_MAX_KG) {
	    			System.out.println("Please, make sure the weight is between 10kg and 300kg.");		    			
	    		}
    		}
    		catch(Exception e) {
    	    	System.out.println("Please, make sure you entered a numerical value for weight (in kilograms).");
    		}
	    }
	    
    	while (height < HEIGHT_MIN_METERS || height > HEIGHT_MAX_METERS) {
    		
    		System.out.print("Enter the height (in meters): ");

    		try {
    			height = Double.parseDouble(scanner.next());
    			
    			if (height < HEIGHT_MIN_METERS || height > HEIGHT_MAX_METERS) {
    				System.out.println("Please, make sure the height is between 0.2m and 2.2m.");	    		
    			}
    		}
			catch(Exception e) {
		    	System.out.println("Please, make sure you entered a numerical value for height (in meters).");
		    }
    	}

	    // Instantiating the object to calculate the BMI with the user inputs
    	// to display the recommendation phrase
	    BMI bmiCalculation = new BMI(weight, height);
	            
	    recommendation = bmiCalculation.findRecommendation();
	        
	    System.out.println("For your BMI, the Singaporean health risk says: " + recommendation);
	    
	    scanner.close();
	}
}