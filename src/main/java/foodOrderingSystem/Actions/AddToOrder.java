package foodOrderingSystem.Actions;

import foodOrderingSystem.Choices.ChooseOptional;
import foodOrderingSystem.Choices.MainMenu;
import foodOrderingSystem.Choices.SelectableMenuAction;
import foodOrderingSystem.Order;
import foodOrderingSystem.OrderController;
import foodOrderingSystem.Models.Limitable;
import foodOrderingSystem.Models.Optional;
import foodOrderingSystem.Models.Orderable;

public class AddToOrder implements OrderAction {
  private Orderable elementToBeAdded;
  private SelectableMenuAction nextMenuAction;

  public AddToOrder(Orderable elementToBeAdded) {
    this.elementToBeAdded = elementToBeAdded;
  }

  @Override
  public void execute() {
    Order order = OrderController.getCurrentOrder();
    order.add(elementToBeAdded);

    System.out.println("Added " + elementToBeAdded.getName() + " to your order.\n");
  }

  public AddToOrder then(SelectableMenuAction nextMenuAction){
    this.nextMenuAction = nextMenuAction;
    return this;
  }

  @Override
  public SelectableMenuAction getNextMenuAction() {
    if(nextMenuAction != null ){

      if(elementToBeAdded instanceof Limitable) {
        ((ChooseOptional) nextMenuAction).removeOptionalIfReachedLimit((Optional) elementToBeAdded);
      }

      return nextMenuAction;
    }
    else {
      return new MainMenu("Anything else?");
    }
  }
}
