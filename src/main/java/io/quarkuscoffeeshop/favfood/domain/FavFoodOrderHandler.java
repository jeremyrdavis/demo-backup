package io.quarkuscoffeeshop.favfood.domain;

import io.quarkuscoffeeshop.domain.Item;
import io.quarkuscoffeeshop.domain.LineItem;
import io.quarkuscoffeeshop.domain.OrderInCommand;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class FavFoodOrderHandler {

    static Set<String> beverages = new HashSet<>(Arrays.asList("COFFEE_BLACK", "COFFEE_WITH_ROOM", "CAPUCCINO", "ESPRESSO", "ESPRESSO_DOUBLE"));
    static Set<String> kitchen = new HashSet<>(Arrays.asList("CROISSANT", "CROISSANT_CHOCOLATE", "MUFFIN", "CAKEPOP"));

    public static OrderInCommand handleFavFoodOrder(final FavFoodOrder favFoodOrder) {

        OrderInCommand orderInCommand = new OrderInCommand();

        List<LineItem> beverages = new ArrayList();
        List<LineItem> kitchenOrders = new ArrayList();

        favFoodOrder.getLineItems().forEach(favFoodLineItem -> {
            if (beverages.contains(favFoodLineItem.item)) {
                for (int i = 0; i < favFoodLineItem.quantity; i++) {
                    beverages.add(new LineItem(findItem(favFoodLineItem.item),favFoodOrder.customerName));
                }
            }
            if (kitchen.contains(favFoodLineItem.item)) {
                for (int i = 0; i < favFoodLineItem.quantity; i++) {
                    kitchenOrders.add(new LineItem(findItem(favFoodLineItem.item),favFoodOrder.customerName));
                }
            }
        });

        orderInCommand.addBeverages(favFoodOrder.orderId, beverages);
        orderInCommand.addBeverages(favFoodOrder.orderId, kitchenOrders);
        return orderInCommand;
    }

    private static Item findItem(String desiredItem) {
        Item item = Item.COFFEE_BLACK;

        switch (desiredItem) {
            case("COFFEE_BLACK"):
                item = Item.COFFEE_BLACK;
                break;
            case("COFFEE_WITH_ROOM"):
                item = Item.COFFEE_WITH_ROOM;
                break;
            case("CAPUCCINO"):
                item = Item.CAPPUCCINO;
                break;
            case("ESPRESSO"):
                item = Item.ESPRESSO;
                break;
            case("ESPRESSO_DOUBLE"):
                item = Item.ESPRESSO_DOUBLE;
                break;
            case("CROISSANT"):
                item = Item.CROISSANT;
                break;
            case("CROISSANT_CHOCOLATE"):
                item = Item.CROISSANT_CHOCOLATE;
                break;
            case("MUFFIN"):
                item = Item.MUFFIN;
                break;
            case("CAKEPOP"):
                item = Item.CAKEPOP;
                break;
        }
        return item;
    }



}
