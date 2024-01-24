package com.javahongkong.bootcamp.exercise;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        this.ordersOfFurnitures = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        if (this.ordersOfFurnitures.containsKey(type))
            this.ordersOfFurnitures.put(type, this.ordersOfFurnitures.get(type) + furnitureCount);
        else
            this.ordersOfFurnitures.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        float totalCost = 0.0f;
        for (Map.Entry<Furniture, Integer> f : this.ordersOfFurnitures.entrySet())
            totalCost += f.getValue() * f.getKey().cost();
        return totalCost;
    }

    public int getTypeCount(Furniture type) {
        if (!this.ordersOfFurnitures.containsKey(type))
            return 0;
        return this.ordersOfFurnitures.get(type);
    }

    public float getTypeCost(Furniture type) {
        if (!this.ordersOfFurnitures.containsKey(type))
            return 0.0f;
        return type.cost() * this.getTypeCount(type);
    }

    public int getTotalOrderQuantity() {
        int totalQuantity = 0;
        for (Map.Entry<Furniture, Integer> f : this.ordersOfFurnitures.entrySet())
            totalQuantity += f.getValue();
        return totalQuantity;
    }
}