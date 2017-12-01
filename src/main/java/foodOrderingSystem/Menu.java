package foodOrderingSystem;

import foodOrderingSystem.Models.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu {
    public static final String defaultMsg = "Good morning. Make your order:";

    private ArrayList<Orderable> items = new ArrayList<>();
    private ArrayList<Cuisine> cuisines = new ArrayList<>();

    public Menu() {
    }

    public ArrayList<Orderable> getItems() {
        return items;
    }

    public <T> ArrayList<T> getListOf(Class<T> clazz){
        return new ArrayList<>(items.stream().filter(clazz::isInstance).map(clazz::cast).collect(Collectors.toList()));
    }

    public ArrayList<Cuisine> getCuisines() {
        return cuisines;
    }

    public void add(Orderable elementToBeAdded) {
        items.add(elementToBeAdded);
    }

    public void addCuisine(Cuisine cuisine) {
        cuisines.add(cuisine);
    }
}
