package foodOrderingSystem.Choices;

import foodOrderingSystem.Actions.AddToOrder;
import foodOrderingSystem.CliMenu;
import foodOrderingSystem.Models.Dessert;

import java.util.ArrayList;

public class ChooseDesert implements MenuChoice {
    private CliMenu cliMenu = new CliMenu("Choose your dessert:");

    @Override
    public void buildMenu() {
        ArrayList<Dessert> desserts = menu.getListOf(Dessert.class);

        for(Dessert dessert : desserts) {
            cliMenu.addOption(dessert.getName() + " " + dessert.getPrice() + "zł", new AddToOrder(dessert));
        }

        cliMenu.setLastOptionAtZero("I've changed my mind.", new MainMenu("Anything else?"));
    }

    @Override
    public CliMenu getCliMenu() {
        return cliMenu;
    }
}
