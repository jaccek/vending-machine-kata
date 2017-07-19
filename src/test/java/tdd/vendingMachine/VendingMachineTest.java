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

    @Before
    public void setUp() {
        List<Shelve> shelves = new ArrayList<>();
        shelves.add(new Shelve());
        shelves.add(new Shelve());

        vendingMachine.fillShelves(shelves);
    }

    @Test
    public void testSelectShelve_shelveExists() throws Exception {
        int shelveNumber = 1;

        vendingMachine.selectShelve(shelveNumber);

        verify(display).showAmountToPay(new BigDecimal("11.05"));
    }

    @Test(expected = ShelveNotExists.class)
    public void testSelectShelve_shelveNotExists() throws Exception {
        int shelveNumber = 100;

        vendingMachine.selectShelve(shelveNumber);
    }
}
