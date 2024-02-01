
public class BMI {
	
	private double weightInKg;
	private double heightInMeters;	
	
	// The parameterized constructor that will instantiate the object:
	public BMI(double weightInKg, double heightInMeters) {
		this.weightInKg = weightInKg;
		this.heightInMeters = heightInMeters;
	}
	
	private double calculateBMI() {
		double bmi = weightInKg / (heightInMeters * heightInMeters);
        return bmi;
	}

	public String findRecommendation() {
		double bmi = calculateBMI();
		String recommendation = "";
		
		if (bmi < 18.5) {
            recommendation = "Possible nutritional deficiency and osteoporosis.";
            return recommendation;
        }
        else if (bmi < 23.0) {
            recommendation = "Low risk (healthy range).";
            return recommendation;
        }
        else if (bmi <27.5) {
            recommendation = "Moderate risk of developing heart disease, high blood pressure, stroke, diabetes mellitus.";
            return recommendation;
        }
        else {
            recommendation = "High risk of developing heart disease, high blood pressure, stroke, diabetes mellitus. Metabolic Syndrome.";
            return recommendation;
        }
	}
}