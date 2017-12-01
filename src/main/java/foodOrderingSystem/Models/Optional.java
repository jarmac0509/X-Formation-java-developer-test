package foodOrderingSystem.Models;

import java.math.BigDecimal;

public class Optional implements Orderable, Limitable {
    private String name;
    private BigDecimal price;
    private int limit;
    private int boughtCount = 0;

    public Optional(String name, double price, int limit) {
        this.name = name;
        this.price = new BigDecimal(price).setScale(2, BigDecimal.ROUND_DOWN);
        this.limit = limit;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public void increaseBoughtCount() {
        this.boughtCount++;
    }

    @Override
    public int getBoughtCount() {
        return boughtCount;
    }
}
