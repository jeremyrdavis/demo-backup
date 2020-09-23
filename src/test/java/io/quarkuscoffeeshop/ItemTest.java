package io.quarkuscoffeeshop;

import io.quarkuscoffeeshop.domain.Item;
import org.junit.jupiter.api.Test;

public class ItemTest {


    @Test
    public void testFindItem() {
        String desiredItem = "COFFEE_BLACK";
        Item actualItem;

        switch (desiredItem) {
            case ("COFFEE_BLACK"):
                actualItem = Item.COFFEE_BLACK;
                break;
        }

    }
}
