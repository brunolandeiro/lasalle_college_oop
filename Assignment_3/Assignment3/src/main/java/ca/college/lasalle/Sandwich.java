package ca.college.lasalle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */

public class Sandwich extends Product implements Edible, Comparable<Sandwich> {
    private double numberOfCalories;
    private LocalDate expiryDate;
    private SandwichSize size;
    private SandwichMainIgredient mainIgredient;

    protected Sandwich(String name, BigDecimal price, double numberOfCalories, LocalDate expiryDate, SandwichSize size, SandwichMainIgredient mainIgredient) {
        super(name, price, ProductType.SANDWICH);
        if(numberOfCalories < 0 || numberOfCalories > 3000){
            throw new InvalidCalories("The number of calories must be between 0 and 3000.");
        }
        this.numberOfCalories = numberOfCalories;
        this.expiryDate = expiryDate;
        this.size = size;
        this.mainIgredient = mainIgredient;
    }

    @Override
    public Double getNumberOfCalories() {
        return this.numberOfCalories;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                " id=" + getId() +
                " name=" + getName() +
                ", price=$" + getPrice() +
                ", numberOfCalories=" + numberOfCalories +
                ", expiryDate=" + expiryDate +
                ", size=" + size +
                ", mainIgredient=" + mainIgredient +
                '}';
    }

    @Override
    public int compareTo(Sandwich o) {
        return this.getPrice().compareTo(o.getPrice());
    }
}