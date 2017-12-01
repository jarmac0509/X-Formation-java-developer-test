package foodOrderingSystem;

import foodOrderingSystem.Choices.SelectableMenuAction;

import java.util.*;

public class CliMenu {
    private String description;
    private List<String> options = new ArrayList<>(Collections.singletonList(""));
    private Map<String, SelectableMenuAction> actionsForOptions = new HashMap<>();

    public CliMenu() {
    }

    public CliMenu(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastOptionAtZero(String lastOptionAtZero, SelectableMenuAction action) {
        options.set(0, lastOptionAtZero);
        actionsForOptions.put(lastOptionAtZero, action);
    }

    public CliMenu addOption(String option, SelectableMenuAction action) {
        options.add(option);
        actionsForOptions.put(option, action);
        return this;
    }

    public void removeOption(String option) {
        options.remove(option);
    }

    public String getOption(int index) {
        return options.get(index);
    }

    public SelectableMenuAction getNextSelectable(String option) {
        return actionsForOptions.get(option);
    }

    public int numberOfOptions() {
        return this.options.size();
    }

    public void printOptions() {
        System.out.println(this.description);

        ListIterator<String> optionsIterator = this.options.listIterator();
        optionsIterator.next();

        while (optionsIterator.hasNext()) {
            System.out.println(optionsIterator.nextIndex()+". "+optionsIterator.next());
        }

        System.out.println("O. " + options.get(0));
    }
}
