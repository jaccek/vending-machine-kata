package tdd.vendingMachine;

import java.math.BigDecimal;

public class Product {

    private BigDecimal prize;
    private String name;

    public Product(String name, BigDecimal prize) {
        this.prize = prize;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrize() {
        return prize;
    }
}
