package foodOrderingSystem.Models;

import java.math.BigDecimal;

public class Drink implements Orderable {
    private String name;
    private BigDecimal price;

    public Drink(String name, double price) {
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
