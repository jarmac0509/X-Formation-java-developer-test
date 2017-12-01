package foodOrderingSystem.Actions;

import foodOrderingSystem.Choices.SelectableMenuAction;
import foodOrderingSystem.Order;
import foodOrderingSystem.OrderController;

import java.math.BigDecimal;

public class FinishOrder implements OrderAction {

  @Override
  public void execute() {
    Order order = OrderController.getCurrentOrder();

    if (order.getPrice().equals(BigDecimal.ZERO)) {
      System.out.println("Your order is empty.\n");
    } else {
      System.out.println("Thank you for your order.");
      order.printOrder();
    }
  }

  @Override
  public SelectableMenuAction getNextMenuAction() {
    return null;
  }
}
