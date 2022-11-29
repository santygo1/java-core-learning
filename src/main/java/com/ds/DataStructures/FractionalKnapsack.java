package com.ds.DataStructures;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Danil on 26.11.2022
 * @project JavaCoreLearning
 */
public class FractionalKnapsack {

    public static void main(String[] args) {
        final Item item1 = new Item(4,20);
        final Item item2 = new Item(3,18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};

        // сортируем по удельной стоимости от большего к меньшему
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());
        final int W = 7;

        int weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;

        while (currentItem < items.length && weightSoFar != W){
            if (weightSoFar + items[currentItem].getWeight() < W){
                //берем полностью
                valueSoFar+=items[currentItem].getValue();
                weightSoFar+=items[currentItem].getWeight();
            }else{
                valueSoFar+= (W-weightSoFar)/ (double)(items[currentItem].getWeight() * items[currentItem].getValue());
                weightSoFar = W;
            }

            currentItem++;
        }

    }
}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.value = value;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double valuePerUnitOfWeight() {
        return value / (double) weight;
    }

    @Override
    public String toString() {
        return "{"
                + "w: " + weight + " "
                + "v: " + value
                + "}";
    }
}
