package tdd.vendingMachine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tdd.vendingMachine.display.Display;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VendingMachineTest {

    @Mock
    private Display display;

    @InjectMocks
    private VendingMachine vendingMachine;

    private List<Product> shelves;

    @Before
    public void setUp() {
        shelves = new ArrayList<>();
        shelves.add(new Product("Cola", new BigDecimal("3.25")));
        shelves.add(new Product("Kitkat", new BigDecimal("1.69")));

        vendingMachine.fillShelves(shelves);
    }

    @Test
    public void testSelectShelve_shelveExists() throws Exception {
        int shelveNumber = 1;

        vendingMachine.selectShelve(shelveNumber);

        verify(display).showAmountToPay(shelves.get(shelveNumber).getPrize());
    }

    @Test(expected = ShelveNotExists.class)
    public void testSelectShelve_shelveNotExists() throws Exception {
        int shelveNumber = 100;

        vendingMachine.selectShelve(shelveNumber);
    }
}
