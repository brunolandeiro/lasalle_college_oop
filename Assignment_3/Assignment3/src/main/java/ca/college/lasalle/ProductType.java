package ca.college.lasalle;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */

public enum ProductType {
    GAS("Gas"),
    CHOCOLATE_BAR("Chocolate Bars"),
    COFFEE("Coffees"),
    SANDWICH("Sandwiches");

    private String description;

    ProductType(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}