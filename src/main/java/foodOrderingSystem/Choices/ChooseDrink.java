package foodOrderingSystem.Choices;

import foodOrderingSystem.Actions.AddToOrder;
import foodOrderingSystem.CliMenu;
import foodOrderingSystem.Models.Drink;

import java.util.ArrayList;

public class ChooseDrink implements MenuChoice {
    private CliMenu cliMenu = new CliMenu("Choose your drink:");

    @Override
    public void buildMenu() {

        ArrayList<Drink> drinks = MenuChoice.menu.getListOf(Drink.class);

        for(Drink drink : drinks) {
            String option = drink.getName() + " " + drink.getPrice() + "zł";
            cliMenu.addOption(option, new AddToOrder(drink).then(new ChooseOptional()));
        }

        cliMenu.setLastOptionAtZero("Back", new MainMenu("Anything else?"));
    }

    @Override
    public CliMenu getCliMenu() {
        return cliMenu;
    }
}
