package io.quarkuscoffeeshop.favfood.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class FavFoodOrder {

    String customerName;

    String orderId;

    List<FavFoodLineItem> lineItems;

    public FavFoodOrder() {
    }

    public FavFoodOrder(String customerName, String orderId, List<FavFoodLineItem> lineItems) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FavFoodOrder.class.getSimpleName() + "[", "]")
                .add("customerId='" + customerName + "'")
                .add("orderId='" + orderId + "'")
                .add("lineItems=" + lineItems)
                .toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavFoodOrder that = (FavFoodOrder) o;
        return Objects.equals(customerName, that.customerName) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(lineItems, that.lineItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, orderId, lineItems);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<FavFoodLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<FavFoodLineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
