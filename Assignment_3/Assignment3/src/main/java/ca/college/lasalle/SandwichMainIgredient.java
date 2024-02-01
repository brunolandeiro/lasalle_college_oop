package ca.college.lasalle;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */

public enum SandwichMainIgredient {
    CHICKEN(0, "Chicken"),
    MEAT(1, "Meat"),
    VEGGIE(2, "Veggie");

    private int id;
    private String description;

    SandwichMainIgredient(int id, String description){
        this.id = id;
        this.description = description;
    }

    public int getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return "SandwichMainIgredient{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public static SandwichMainIgredient findBy(int id){
        return SandwichMainIgredient.values()[id];
    }

    public static void displayAll(){
        for(SandwichMainIgredient size : SandwichMainIgredient.values()){
            System.out.println(size);
        }
    }
}
