package ca.college.lasalle;

import java.util.Arrays;

/**
 * Ayrton Amaral - 202234145
 * Bruno Landeiro - 202234156
 * Carolina Ruiz - 202234358
 * */

public enum SandwichSize {
    SMALL(0, "Small"),
    MEDIUM(1, "Medium"),
    LARGE(2, "Large");

    private int id;
    private String description;

    SandwichSize(int id, String description){
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
        return "SandwichSize{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public static SandwichSize findBy(int id){
        return SandwichSize.values()[id];
    }

    public static void displayAll(){
        for(SandwichSize size : SandwichSize.values()){
            System.out.println(size);
        }
    }
}