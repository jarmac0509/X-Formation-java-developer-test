package foodOrderingSystem.Choices;

import foodOrderingSystem.CliMenu;

public class DesertQuestion implements MenuChoice {
    private CliMenu cliMenu = new CliMenu("Do you want dessert?");

    @Override
    public void buildMenu() {
        cliMenu.addOption("Yes", new ChooseDesert())
                .setLastOptionAtZero("No", new MainMenu("Anything else?"));
    }

    @Override
    public CliMenu getCliMenu() {
        return cliMenu;
    }
}
