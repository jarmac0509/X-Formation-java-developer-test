package foodOrderingSystem;

import foodOrderingSystem.Choices.MainMenu;
import foodOrderingSystem.Choices.SelectableMenuAction;

public class OrderController {
  private static Order order;

  public void newOrderInteraction() {
    order = new Order();

    SelectableMenuAction menuChoice = new MainMenu(Menu.defaultMsg);

    while (menuChoice != null) {
      menuChoice.execute();
      menuChoice = menuChoice.getNextMenuAction();
    }

    newOrderInteraction();
  }

  public static Order getCurrentOrder() {
    return order;
  }
}
