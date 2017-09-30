package foodOrderingSystem;

import foodOrderingSystem.models.Cuisine;
import foodOrderingSystem.models.Dessert;
import foodOrderingSystem.models.Dish;
import foodOrderingSystem.models.Drink;

import java.util.ArrayList;

public class Menu {
    public static final String defaultMsg = "Good morning. Make your order:";
    private ArrayList<Drink> listOfDrinks = new ArrayList<>();
    private ArrayList<Cuisine> listOfCuisines = new ArrayList<>();
    private ArrayList<Dessert> listOfDesserts = new ArrayList<>();
    private ArrayList<String> listOfOptionals = new ArrayList<>();

    public Menu() {
    }

    public Menu(ArrayList<Drink> listOfDrinks, ArrayList<Cuisine> listOfCuisines, ArrayList<Dessert> listOfDesserts) {
        this.listOfDrinks = listOfDrinks;
        this.listOfCuisines = listOfCuisines;
        this.listOfDesserts = listOfDesserts;
    }

    public ArrayList<Drink> getListOfDrinks() {
        return listOfDrinks;
    }

    public ArrayList<Cuisine> getListOfCuisines() {
        return listOfCuisines;
    }

    public ArrayList<Dessert> getListOfDesserts() {
        return listOfDesserts;
    }

    public ArrayList<String> getListOfOptionals() {
        return listOfOptionals;
    }

    public void addDrink(Drink drink) {
        listOfDrinks.add(drink);
    }

    public void addCuisine(Cuisine cuisine) {
        listOfCuisines.add(cuisine);
    }

    public void addDessert(Dessert dessert) {
        listOfDesserts.add(dessert);
    }

    public void addOptional(String optional) {
        listOfOptionals.add(optional);
    }

    public static Menu buildBasicMenu(){
        Menu menu = new Menu();

        menu.addDrink(new Drink("Coca-cola", 5));
        menu.addDrink(new Drink("Tea", 4));
        menu.addDrink(new Drink("Coffee", 6));
        menu.addDrink(new Drink("Sprite", 5));
        menu.addDrink(new Drink("Water", 4));

        Cuisine polishCuisine = new Cuisine("Polish");
        polishCuisine.addDish(new Dish("Bigos", 12));
        polishCuisine.addDish(new Dish("Pierogi", 15));
        polishCuisine.addDish(new Dish("Zalewajka", 8));
        menu.addCuisine(polishCuisine);

        Cuisine mexicanCuisine = new Cuisine("Mexican");
        mexicanCuisine.addDish(new Dish("Fajitas", 15));
        mexicanCuisine.addDish(new Dish("Tacos", 12));
        mexicanCuisine.addDish(new Dish("Burrito", 13));
        menu.addCuisine(mexicanCuisine);

        Cuisine italianCuisine = new Cuisine("Italian");
        italianCuisine.addDish(new Dish("Spaghetti", 12));
        italianCuisine.addDish(new Dish("Pizaa", 13));
        italianCuisine.addDish(new Dish("Lasagne", 14));
        menu.addCuisine(italianCuisine);

        menu.addDessert(new Dessert("Cookie", 4));
        menu.addDessert(new Dessert("Apple", 3));
        menu.addDessert(new Dessert("Cake", 5));

        menu.addOptional("Ice cubes free");
        menu.addOptional("Lemon free");

        return menu;
    }
}
