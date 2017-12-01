package foodOrderingSystem.Choices;

import foodOrderingSystem.Actions.AddToOrder;
import foodOrderingSystem.CliMenu;
import foodOrderingSystem.Models.Cuisine;
import foodOrderingSystem.Models.Dish;

public class ChooseDishFrom implements MenuChoice {
    private Cuisine cuisine;
    private CliMenu cliMenu = new CliMenu("Choose your dish:");

    public ChooseDishFrom(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public void buildMenu() {

        for(Dish dish : cuisine.getListOfDishes()) {
            cliMenu.addOption(dish.getName() + " " + dish.getPrice() + "zł", new AddToOrder(dish).then(new DesertQuestion()));
        }

        cliMenu.setLastOptionAtZero("Back", new ChooseLunch());
    }

    @Override
    public CliMenu getCliMenu() {
        return cliMenu;
    }
}
