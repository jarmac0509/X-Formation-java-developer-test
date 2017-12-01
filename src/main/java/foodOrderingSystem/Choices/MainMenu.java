package foodOrderingSystem.Choices;

import foodOrderingSystem.Actions.FinishOrder;
import foodOrderingSystem.CliMenu;

public class MainMenu implements MenuChoice {

    private CliMenu cliMenu;

    public MainMenu(String msg) {
        this.cliMenu = new CliMenu(msg);
    }

    @Override
    public void buildMenu() {
        cliMenu.addOption("Lunch", new ChooseLunch())
                .addOption("Drink", new ChooseDrink())
                .setLastOptionAtZero("That's all", new FinishOrder());
    }

    @Override
    public CliMenu getCliMenu() {
        return cliMenu;
    }
}
