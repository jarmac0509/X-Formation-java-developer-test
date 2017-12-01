package foodOrderingSystem.Choices;

import foodOrderingSystem.Actions.AddToOrder;
import foodOrderingSystem.CliMenu;
import foodOrderingSystem.Models.Optional;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ChooseOptional implements MenuChoice {
    private CliMenu cliMenu;
    private ArrayList<Optional> optionals;

  @Override
    public void buildMenu() {
    cliMenu = new CliMenu("Optional: ");

    if (optionals == null) {
      optionals = menu.getListOf(Optional.class);
    }

    for(Optional optional : optionals) {
      String price = optional.getPrice().equals(BigDecimal.ZERO) ? optional.getPrice() + "zł" : "free";
      String option = optional.getName() + " " + price;
      cliMenu.addOption(option, new AddToOrder(optional).then(this));
    }

    cliMenu.setLastOptionAtZero("Nothing more", new MainMenu("Anything else?"));
    }

    public void removeOptionalIfReachedLimit(Optional optional) {
      this.optionals.get(optionals.indexOf(optional)).increaseBoughtCount();
      this.optionals.removeIf(o -> o.getLimit() == o.getBoughtCount());
    }

    @Override
    public CliMenu getCliMenu() {
        return cliMenu;
    }
}
