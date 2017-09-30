package foodOrderingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CliMenu {
    private String description;
    private List<String> options = new ArrayList<>();
    private String lastOptionAtZero;

    private Scanner scanner = new Scanner(System.in);

    public CliMenu(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastOptionAtZero(String lastOptionAtZero) {
        this.lastOptionAtZero = lastOptionAtZero;
    }

    public CliMenu addOption(String option) {
        options.add(option);
        return this;
    }

    public int numberOfOptions() {
        int numberOfoptions = this.options.size();
        if (lastOptionAtZero != null)
            numberOfoptions++;
        return numberOfoptions;
    }

    public void printOptions() {
        System.out.println(this.description);
        int i = 1;
        for(String option : options){
            System.out.println((i++) + ". " + option);
        }
        if (lastOptionAtZero != null) {
            System.out.println("0. " + lastOptionAtZero);
        }
    }

    public int getUserChoice() {
        int selectedNumber = -1;
        boolean isNumberValid = false;
        while (!isNumberValid){

            try {
                selectedNumber = scanner.nextInt();
                if (selectedNumber < this.numberOfOptions() && selectedNumber >= 0) {
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
