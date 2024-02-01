public class Main {

    public static void main(String[] args) {
        System.out.println("\n****** Final Exam ******\n");
        Menu menu = new Menu();
        do {
            menu.displayMenu();
            menu.selectOption();
            switch(menu.getSelectedOption()) {
                case 1:
                    ProductsController.addRentalProduct(ProductType.CONSTRUCTION_EQUIPMENT);
                    break;
                case 2:
                    ProductsController.addRentalProduct(ProductType.MOTOCYCLE);
                    break;
                case 3:
                    ProductsController.addRentalProduct(ProductType.BOOK);
                    break;
                case 4:
                    ProductsController.rentEquipment();
                    break;
                case 5:
                    ProductsController.displayRentedEquipment();
                    break;
                case 6:
                    ProductsController.displayNotRentedEquipment();
                    break;
            }
        }while(menu.getSelectedOption()!=7);
    }

}