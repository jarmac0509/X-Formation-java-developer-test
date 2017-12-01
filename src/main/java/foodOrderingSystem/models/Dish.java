package foodOrderingSystem.Models;

import java.math.BigDecimal;

public class Dish implements Orderable {
    private String name;
    private BigDecimal price;
    private Cuisine cuisine;

    public Dish(String name, double price) {
        this.name = name;
        this.price = new BigDecimal(price).setScale(2, BigDecimal.ROUND_DOWN);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
