package foodOrderingSystem;

import foodOrderingSystem.Models.Cuisine;
import foodOrderingSystem.Models.Dessert;
import foodOrderingSystem.Models.Dish;
import foodOrderingSystem.Models.Drink;
import foodOrderingSystem.Models.Optional;
import foodOrderingSystem.Models.Orderable;

public class MenuBuilder {
  private Menu menu;

  public MenuBuilder() {
    this.menu = new Menu();
  }

  MenuBuilder addItem(Orderable item) {
    menu.add(item);
    return this;
  }

  MenuBuilder addCuisine(Cuisine cuisine) {
    menu.addCuisine(cuisine);
    return this;
  }

  private Menu build() {
    return menu;
  }

  public Menu buildBasicMenu() {


    Cuisine polishCuisine = new Cuisine("Polish")
        .addDish(new Dish("Bigos", 11.99))
        .addDish(new Dish("Pierogi", 12.99))
        .addDish(new Dish("Zalewajka", 7.99));

    Cuisine mexicanCuisine = new Cuisine("Mexican")
        .addDish(new Dish("Fajitas", 15.99))
        .addDish(new Dish("Tacos", 12.99))
        .addDish(new Dish("Burrito", 13.99));

    Cuisine italianCuisine = new Cuisine("Italian")
        .addDish(new Dish("Spaghetti", 12.99))
        .addDish(new Dish("Pizaa", 14.99))
        .addDish(new Dish("Lasagne", 13.99));

    Cuisine russianCuisine = new Cuisine("Russian")
        .addDish(new Dish("Cheap vodka", 12.99))
        .addDish(new Dish("Super vodka", 14.99))
        .addDish(new Dish("Vodka", 13.99));

    MenuBuilder menuBuilder = new MenuBuilder()
        .addCuisine(polishCuisine)
        .addCuisine(mexicanCuisine)
        .addCuisine(italianCuisine)
        .addCuisine(russianCuisine)

        .addItem(new Drink("Coca-cola", 4.99))
        .addItem(new Drink("Tea", 4.99))
        .addItem(new Drink("Coffee", 5.99))
        .addItem(new Drink("Sprite", 4.99))
        .addItem(new Drink("Water", 3.99))

        .addItem(new Dessert("Cookie", 4.5))
        .addItem(new Dessert("Apple", 3.2))
        .addItem(new Dessert("Cake", 5))

        .addItem(new Optional("Ice cubes", 0, 1))
        .addItem(new Optional("Lemon", 0, 1))
        .addItem(new Optional("Sugar", 0, 5))
        .addItem(new Optional("Pickles", 1, 1));

    return menuBuilder.build();
  }
}
