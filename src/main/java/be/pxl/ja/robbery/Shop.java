package be.pxl.ja.robbery;

import be.pxl.ja.knapsack.Inventory;
import be.pxl.ja.knapsack.Item;

public class Shop extends Inventory implements Item {
    private String name;
    private double time;
    private Inventory _shopInventory;

    public Shop(Inventory _inventory) {
        this._shopInventory = _inventory;
    }

    @Override
    public double getWeigth() {
        return time;
    }

    @Override
    public String getName() {
        return name;
    }
}
