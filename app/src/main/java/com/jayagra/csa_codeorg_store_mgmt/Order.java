package com.jayagra.csa_codeorg_store_mgmt;

public class Order {
    private Item item;
    private int quantity;

    public Order() {
        this(new Item(), 0);
    }

    public Order(final Item item_, final int quantity_) {
        this.item = item_;
        this.quantity = quantity_;
    }

    public Item getItem() {
        return this.item;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setItem(final Item newItem) {
        this.item = newItem;
    }

    public void setQuantity(final int newQuantity) {
        this.quantity = newQuantity;
    }

    public String toString() {
        return "This order is made up of " + this.quantity + " " + this.item.getDescription() + "(s).";
    }
}
