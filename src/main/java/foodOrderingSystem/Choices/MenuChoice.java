package foodOrderingSystem.Choices;

import foodOrderingSystem.CliMenu;
import foodOrderingSystem.Menu;
import foodOrderingSystem.MenuBuilder;

import java.util.Scanner;

public interface MenuChoice extends SelectableMenuAction {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new MenuBuilder().buildBasicMenu();

    void buildMenu();
    CliMenu getCliMenu();

    @Override
    default SelectableMenuAction getNextMenuAction() {
        String option = getCliMenu().getOption(getUserChoice());
        return getCliMenu().getNextSelectable(option);
    }

    @Override
    default void execute() {
        buildMenu();
        showChoices();
    }

    default void showChoices() {
        getCliMenu().printOptions();
    }

    default int getUserChoice() {
        int selectedNumber = -1;
        boolean isNumberValid = false;
        while (!isNumberValid){

            try {
                selectedNumber = scanner.nextInt();
                if (selectedNumber < getCliMenu().numberOfOptions() && selectedNumber >= 0) {
                    isNumberValid = true;
                }
                else {
                    System.out.println("Invalid number. Try again");
                }
            }
            catch (Exception e){
                System.out.println("Invalid number. Try again");
            }
            scanner.nextLine();

        }
        return selectedNumber;
    }
}
