package tdd.vendingMachine;

import tdd.vendingMachine.display.Display;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private Display display;

    private List<Product> shelves = new ArrayList<>();

    public void fillShelves(List<Product> shelves) {
        this.shelves = shelves;
    }

    public void selectShelve(int number) throws ShelveNotExists {
        if (number < shelves.size()) {
            display.showAmountToPay(shelves.get(number).getPrize());
        } else {
            throw new ShelveNotExists();
        }
    }
}
