package foodOrderingSystem.Choices;

import foodOrderingSystem.CliMenu;
import foodOrderingSystem.Models.Cuisine;

import java.util.ArrayList;

public class ChooseLunch implements MenuChoice {
    private CliMenu cliMenu = new CliMenu("Choose cuisine:");

    @Override
    public void buildMenu() {

        ArrayList<Cuisine> cuisines = menu.getCuisines();

        for (Cuisine cuisine : cuisines) {
            cliMenu.addOption(cuisine.getName(), new ChooseDishFrom(cuisine));
        }

        cliMenu.setLastOptionAtZero("Back", new MainMenu("Anything else?"));
    }

    @Override
    public CliMenu getCliMenu() {
        return cliMenu;
    }
}
