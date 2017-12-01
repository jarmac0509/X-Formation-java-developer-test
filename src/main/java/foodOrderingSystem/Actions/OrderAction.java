package foodOrderingSystem.Actions;

import foodOrderingSystem.Choices.SelectableMenuAction;

public interface OrderAction extends SelectableMenuAction {
  void execute();
}
