package foodOrderingSystem;

import foodOrderingSystem.Models.Orderable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Order {
  private static int number = 0;
  private ArrayList<Orderable> orderList;
  private BigDecimal price;

  public Order() {
    number++;
    orderList = new ArrayList<>();
    price = BigDecimal.ZERO;
  }

  public ArrayList<Orderable> getOrderList() {
    return this.orderList;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void add(Orderable orderable) {
    orderList.add(orderable);
    price = price.add(orderable.getPrice());
  }

  public void printOrder() {
    System.out.println("\nYour order:");
    System.out.println("****************************\n");

    orderList.forEach(printNameAndPrice());

    System.out.println("\n----------------------------");
    System.out.println("Total price: " + price + "zł");

    System.out.println("Your order number: " + number);

    System.out.println("\n****************************\n");
  }

  private Consumer<Orderable> printNameAndPrice() {
    return e -> System.out.println(" * " + e.getName() + " " + e.getPrice() + "zł");
  }
}
