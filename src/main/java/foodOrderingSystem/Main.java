package foodOrderingSystem;

public class Main {
    public static void main(String[] args) {
        OrderController orderController = new OrderController();

        orderController.mainMenu(Menu.defaultMsg);

    }
}