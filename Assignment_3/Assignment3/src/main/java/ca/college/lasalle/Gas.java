package ca.college.lasalle;

import java.math.BigDecimal;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */

public class Gas extends Product {
    private double amountInTheTanks;

    public Gas(String name, BigDecimal price, double amountInTheTanks) {
        super(name, price,ProductType.GAS);
        this.amountInTheTanks = amountInTheTanks;
    }

    public void addGas(double amount) {
        amountInTheTanks += amount;
    }

    public void sell(double amount){
        if(amount <= 0) {
            throw new RuntimeException("Invalid amount required has to be greater than 0.");
        }
        if(amountInTheTanks < amount){
            throw new RuntimeException(String
                    .format("Not enough fuel in the tanks. (%s L available)", this.amountInTheTanks));
        }
        this.amountInTheTanks -= amount;
    }

    public double getAmountInTheTanks(){
        return this.amountInTheTanks;
    }

    @Override
    public String toString() {
        return "Gas{" + "amountInTheTanks=" + amountInTheTanks + " price: $" + this.getPrice()+'}';
    }
}