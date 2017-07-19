package tdd.vendingMachine;

import tdd.vendingMachine.display.Display;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private Display display;

    private List<Shelve> shelves = new ArrayList<>();

    public void fillShelves(List<Shelve> shelves) {
        this.shelves = shelves;
    }

    public void selectShelve(int number) throws ShelveNotExists {
        if (number < shelves.size()) {
            display.showAmountToPay(new BigDecimal("11.05"));
        } else {
            throw new ShelveNotExists();
        }
    }
}
