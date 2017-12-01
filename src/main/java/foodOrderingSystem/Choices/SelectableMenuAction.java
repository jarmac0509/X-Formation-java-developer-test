package foodOrderingSystem.Choices;

public interface SelectableMenuAction {
    void execute();
    SelectableMenuAction getNextMenuAction();
}
