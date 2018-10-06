package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 06/10/2018
 */

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    private static double getMaxValue(ItemValue[] items, int capacity) {
        double maxWeight = 0d;

        for (ItemValue item : items) {

            int currentWeight = (int) item.weight;
            int currentValue = (int) item.value;

            if (capacity - currentWeight >= 0) {//this weight can be picked while
                capacity = capacity - currentWeight;
                maxWeight += currentValue;

            } else {//item cant be picked whole
                double fraction = ((double) capacity / (double) currentWeight);
                maxWeight += (currentValue * fraction);
                capacity = (int) (capacity - (currentWeight * fraction));
                break;
            }

        }

        return maxWeight;

    }

    // item value class
    private static class ItemValue {
        Double cost;
        double weight, value, ind;

        // item value function
        public ItemValue(int weight, int value, int ind){
            this.weight = weight;
            this.value = value;
            this.ind = ind;
            cost = new Double(value/ weight);
        }

    }

    public static void main(String[] args) {
        int[] weights = {4, 3, 2};
        int[] values = {20, 18, 14};
        int capacity = 7;

        ItemValue[] iVal = new ItemValue[weights.length];

        for(int i = 0; i < weights.length; i++){
            iVal[i] = new ItemValue(weights[i], values[i], i);
        }

        //sorting items by value;
        Comparator<ItemValue> sorter = (item1, item2) -> item2.cost.compareTo(item1.cost);
        Arrays.sort(iVal, sorter);

        double maxValue = getMaxValue(iVal, capacity);

        System.out.println("Maximum value we can obtain = " + maxValue);

        weights = new int[] {10, 40, 20, 30};
        values = new int[] {60, 40, 100, 120};
        capacity = 50;

        iVal = new ItemValue[weights.length];

        for(int i = 0; i < weights.length; i++){
            iVal[i] = new ItemValue(weights[i], values[i], i);
        }

        //sorting items by value;
        Arrays.sort(iVal, sorter);

        maxValue = getMaxValue(iVal, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);

        weights = new int[] {20, 5, 4};
        values = new int[] {20, 10, 20};
        capacity = 10;

        iVal = new ItemValue[weights.length];

        for(int i = 0; i < weights.length; i++){
            iVal[i] = new ItemValue(weights[i], values[i], i);
        }

        //sorting items by value;
        Arrays.sort(iVal, sorter);

        maxValue = getMaxValue(iVal, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
