package foodOrderingSystem;

import foodOrderingSystem.models.*;

import java.math.BigDecimal;
import java.util.*;

public class OrderController {

    private Menu menu = Menu.buildBasicMenu();

    private Order order = new Order();

    public void mainMenu(String msg) {
        CliMenu cliMenu = new CliMenu(msg);

        cliMenu.addOption("Lunch")
                .addOption("Drink")
                .setLastOptionAtZero("That's all");

        cliMenu.printOptions();
        
        int selectedNumber = cliMenu.getUserChoice();
        
        switch (selectedNumber) {
            case 1:
                chooseLunch();
            case 2:
                chooseDrink();
            case 0:
                finishOrder();
        }

    }

    private void finishOrder() {
        if(order.getPrice().equals(BigDecimal.ZERO)){
            System.out.println("Your order is empty.\n");
        }
        else {
            System.out.println("Thank you for your order.");
            order.printOrder();
            //StoreAndPassOrderForWorkers()
            order = new Order();
        }

        mainMenu(Menu.defaultMsg);

    }

    private void chooseDrink() {
        CliMenu cliMenu = new CliMenu("Choose your drink:");

        ArrayList<Drink> drinks = menu.getListOfDrinks();

        for(Drink drink : drinks) {
            String option = drink.getName() + " " + drink.getPrice() + "zł";
            cliMenu.addOption(option);
        }

        cliMenu.setLastOptionAtZero("Back");

        cliMenu.printOptions();

        int selectedNumber = cliMenu.getUserChoice();

        if (selectedNumber == 0) {
            mainMenu(Menu.defaultMsg);
        }
        else {
            order.addDrink(drinks.get(--selectedNumber));

            chooseOptional();
        }

    }

    private void chooseOptional() {
        CliMenu cliMenu = new CliMenu("Optional: ");

        ArrayList<String> optionals = menu.getListOfOptionals();

        for(String optional : optionals) {
            cliMenu.addOption(optional);
        }

        cliMenu.setLastOptionAtZero("Nothing more");

        cliMenu.printOptions();

        int selectedNumber = cliMenu.getUserChoice();

        if (selectedNumber != 0) {
            String optional = optionals.get(--selectedNumber);
            if(order.getOptionals().contains(optional)){
                System.out.println("You can add only one of each optionals.\n");
            }
            else {
                order.addOptional(optional);
            }
            chooseOptional();
        }
        else {
            mainMenu("Anything else?");
        }
    }

    private void chooseLunch() {
        Cuisine cuisine = chooseCuisine();

        ArrayList<Dish> dishes = cuisine.getListOfDishes();

        chooseDishFrom(dishes);

        askForDessert();
    }

    private Cuisine chooseCuisine() {
        CliMenu cliMenu = new CliMenu("Choose cuisine:");

        ArrayList<Cuisine> cuisines = menu.getListOfCuisines();
        for (Cuisine cuisine : cuisines) {
            cliMenu.addOption(cuisine.getName());
        }

        cliMenu.setLastOptionAtZero("Back");

        cliMenu.printOptions();

        int selectedNumber = cliMenu.getUserChoice();

        if (selectedNumber == 0){
            mainMenu(Menu.defaultMsg);
        }

        return cuisines.get(--selectedNumber);
    }

    private void chooseDishFrom(ArrayList<Dish> dishes) {
        CliMenu cliMenu = new CliMenu("Choose your dish:");

        for(Dish dish : dishes) {
            cliMenu.addOption(dish.getName() + " " + dish.getPrice() + "zł");
        }

        cliMenu.setLastOptionAtZero("Back");

        cliMenu.printOptions();

        int selectedNumber = cliMenu.getUserChoice();

        if(selectedNumber == 0) {
            chooseLunch();
        }
        else{
            order.addDish(dishes.get(--selectedNumber));
        }
    }

    private void askForDessert() {
        CliMenu cliMenu = new CliMenu("Would you like dessert?");

        cliMenu.addOption("Yes");
        cliMenu.setLastOptionAtZero("No");

        cliMenu.printOptions();

        int selectedNumber = cliMenu.getUserChoice();

        switch (selectedNumber) {
            case 0:
                mainMenu("Anything else?");
            case 1:
                chooseDessert();
        }
    }

    private void chooseDessert() {
        CliMenu cliMenu = new CliMenu("Choose your dessert:");

        ArrayList<Dessert> desserts = menu.getListOfDesserts();

        for(Dessert dessert : desserts) {
            cliMenu.addOption(dessert.getName() + " " + dessert.getPrice() + "zł");
        }

        cliMenu.setLastOptionAtZero("I've changed my mind.");

        cliMenu.printOptions();

        int selectedNumber = cliMenu.getUserChoice();

        if (selectedNumber != 0) {
            order.addDessert(desserts.get(--selectedNumber));
        }

        mainMenu("Anything else?");
    }
}
