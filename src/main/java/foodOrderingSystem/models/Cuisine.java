package foodOrderingSystem.models;

import java.util.ArrayList;

public class Cuisine {
    private String name;
    private ArrayList<Dish> listOfDishes = new ArrayList<>();

    public Cuisine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Dish> getListOfDishes() {
        return listOfDishes;
    }

    public void setListOfDishes(ArrayList<Dish> listOfDishes) {
        this.listOfDishes = listOfDishes;
    }

    public void addDish(Dish dish) {
        listOfDishes.add(dish);
    }
}
