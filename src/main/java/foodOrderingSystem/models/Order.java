package foodOrderingSystem.models;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {
    private static int number = 0;
    private ArrayList<Dish> dishes = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Dessert> desserts = new ArrayList<>();
    private ArrayList<String> optionals = new ArrayList<>();
    BigDecimal price = BigDecimal.ZERO;

    public Order() {
        number++;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public ArrayList<String> getOptionals() {
        return optionals;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        this.price = this.price.add(dish.getPrice());
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
        this.price = this.price.add(drink.getPrice());
    }

    public void addDessert(Dessert dessert) {
        desserts.add(dessert);
        this.price = this.price.add(dessert.getPrice());
    }

    public void addOptional(String optional) {
        optionals.add(optional);
    }

    public void printOrder() {

        System.out.println("\nYour order:");
        System.out.println("****************************\n");

        dishes.forEach(e -> System.out.println(" * " + e.getName() + " " + e.getPrice() + "zł"));
        desserts.forEach(e -> System.out.println(" * " + e.getName() + " " + e.getPrice() + "zł"));
        drinks.forEach(e -> System.out.println(" * " + e.getName() + " " + e.getPrice() + "zł"));
        optionals.forEach(e -> System.out.println(" * " + e));
        System.out.println("\n----------------------------");
        System.out.println("Total price: " + price + "zł");

        System.out.println("Your order number: " + number);

        System.out.println("\n****************************\n");
    }
}
