package ca.college.lasalle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */

public class Controller {

	public static void mainScreen() {
		Menu menu = new Menu();
		
		do {
	        menu.displayMenu();

	        menu.selectOption();

	        switch(menu.getSelectedOption()) {
				case 1:
					addEdibleProduct(ProductType.CHOCOLATE_BAR);
					break;

				case 2:
					addEdibleProduct(ProductType.SANDWICH);
					break;

				case 3:
					addGas();
					break;

				case 4:
					addEdibleProduct(ProductType.COFFEE);
					break;

				case 5:
					DataProvider.displayAllBy(ProductType.CHOCOLATE_BAR);
					break;

				case 6:
					// Compare two chocolate bars and display which one is healthier
					DataProvider.displayAllBy(ProductType.CHOCOLATE_BAR);
					System.out.println("\nWhich chocolates would you like to compare?");
					ChocolateBar chocolate1 = (ChocolateBar) chooseAProduct("Enter the first chocolate id: ", ProductType.CHOCOLATE_BAR);
					ChocolateBar chocolate2 = (ChocolateBar) chooseAProduct("Enter the second chocolate id: ", ProductType.CHOCOLATE_BAR);
					compareTwoChocolates(chocolate1, chocolate2);
					break;

				case 7:
					DataProvider.displayAllBy(ProductType.SANDWICH);
					break;

				case 8:
					// Compare two sandwiches and display which one is cheaper
					DataProvider.displayAllBy(ProductType.SANDWICH);
					System.out.println("Which sandwiches would you like to compare?");
					Sandwich sandwichOne = (Sandwich) chooseAProduct("Enter the first sandwich id: ", ProductType.SANDWICH);
					Sandwich sandwichTwo = (Sandwich) chooseAProduct("Enter the second sandwich id: ", ProductType.SANDWICH);
					compareTwoSandwiches(sandwichOne, sandwichTwo);
					break;

				case 9:
					sellEdibleProduct();
					break;

				case 10:
					sellGas();
					break;

				case 11:
					sellProduct(ProductType.COFFEE);
					break;

				case 12:
					DataProvider.displayGasInTanks();
					break;
			} // end of switch case
		}while(menu.getSelectedOption()!=13);
	} //end of mainScreen method

	private static void addEdibleProduct(ProductType productType) {
		Product product = null;
		do {
			System.out.println("----------- ADD " + productType.getDescription() + " -----------");
			String name = ConsoleReader.readAsString("What is the name of the new product?");
			BigDecimal price = ConsoleReader.readAsBigDecimal("What is its price?");
			LocalDate expiryDate = ConsoleReader.readAsLocalDate("What is the expiry date? (yyyy-MM-dd): ");
			double numberOfCalories = ConsoleReader.readAsDouble("What is the number of calories?");

			try {
				if(productType.equals(ProductType.SANDWICH)){
					SandwichSize size = chooseASandwichSize();
					SandwichMainIgredient mainIgredient = chooseASandwichMainIgredient();
					product = new Sandwich(name, price, numberOfCalories, expiryDate, size, mainIgredient);
				}
				if(productType.equals(ProductType.CHOCOLATE_BAR)){
					product = new ChocolateBar(name, price, numberOfCalories, expiryDate);
				}
				if(productType.equals(ProductType.COFFEE)){
					product = new Coffee(name, price, numberOfCalories, expiryDate);
				}
			} catch (InvalidCalories exception){
				System.out.println(exception.getMessage());
			}
			if(product != null){
				DataProvider.products.add(product);
				System.out.println("Product added successfully.");
			}
		} while (product == null);
	}

	public static SandwichSize chooseASandwichSize(){
		SandwichSize.displayAll();
		return SandwichSize.findBy(ConsoleReader.readAsInteger("Choose a size:"));
	}

	public static SandwichMainIgredient chooseASandwichMainIgredient(){
		SandwichMainIgredient.displayAll();
		return SandwichMainIgredient.findBy(ConsoleReader.readAsInteger("Choose a main ingredient:"));
	}

	public static Product chooseAProduct(String displayMessage, ProductType type) {
		Product product = null;
		do {
			int id = ConsoleReader.readAsInteger(displayMessage);
			try {
				product = DataProvider.findProductBy(id, type);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		} while (product == null);
		return product;
	}

	public static void sellEdibleProduct() {
		System.out.println("----------- SELL Edible Product -----------");
		DataProvider.displayAllEdibleProducts();
		System.out.println();
		System.out.println("Which product would you like to buy?");
		Edible edible = null;
		do {
			int id = ConsoleReader.readAsInteger("Enter the id of the desired product: ");
			for(Product product : DataProvider.products){
				if(product instanceof Edible && product.getId() == id){
					edible = (Edible) product;
				}
			}
			if(edible != null){
				System.out.println("You have purchased: ");
				System.out.println(edible);
			} else {
				System.out.println("Product id was not found.");
			}
		} while (edible == null);
	}

	public static void sellProduct(ProductType type) {
		System.out.println("----------- SELL Product -----------");
		DataProvider.displayAllBy(type);
		System.out.println();
		Product product = chooseAProduct("Which product would you like to buy?", type);
		System.out.println("You have purchased the product: ");
		System.out.println(product);
	}

	public static void sellGas() {
		System.out.println("----------- SELL GAS -----------");
		double gasLitres = ConsoleReader.readAsDouble("How many liters you need?:");
		Gas gas = (Gas) DataProvider.products.get(0);
		try {
			gas.sell(gasLitres);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addGas() {
		Scanner scanner = new Scanner(System.in);
		double amountOfGas = 0;
		do {
			System.out.println("Enter gas amount to add:");
			try{
				amountOfGas = scanner.nextDouble();
				if(amountOfGas <= 0){
					System.out.println("Gas amount should be a number greater than 0.");
				}
			}
			catch (Exception e){
				System.out.println("Gas amount should be a numerical value.");
				scanner.next();
			}
		} while(amountOfGas <= 0);

		// Casting the product of type Gas and adding
		((Gas) DataProvider.products.get(0)).addGas(amountOfGas);
		System.out.println("The gas amount was added successfully.");
	}

	private static void compareTwoSandwiches(Sandwich sandwichOne, Sandwich sandwichTwo) {
		int result = sandwichOne.compareTo(sandwichTwo);
		if(result == 0) {
			System.out.println("Both sandwiches have the same price.");
		}
		else if(result < 0) {
			System.out.println(String.format("%s \n is cheaper than \n%s", sandwichOne, sandwichTwo));
		}
		else if(result > 0) {
			System.out.println(String.format("%s \n is cheaper than \n%s", sandwichTwo, sandwichOne));
		}
	}

	private static void compareTwoChocolates(ChocolateBar chocolate1, ChocolateBar chocolate2) {
		int result = chocolate1.getNumberOfCalories().compareTo(chocolate2.getNumberOfCalories());

		if(result == 0) {
			System.out.println("Both chocolates have the same number of calories.");
		}
		else if(result < 0) {
			System.out.println(String.format("%s \n is healthier than \n%s", chocolate1, chocolate2));
		}
		else if(result > 0) {
			System.out.println(String.format("%s \n is less healthier than \n%s", chocolate1, chocolate2));
		}
	}
}