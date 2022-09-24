package com.cb.greedy;

import java.util.Arrays;

/*
 *  Time: O(n * log n)
 *  Space: O(n)
 *  Greedy
 * */
public class G4_FractionalKnapsack {

    public static double maxCapacity(Item items[], int n, int w) {

        // time O(n * long n)
        Arrays.sort(items, (o1, o2) -> {
            double ratio1
                    = ((double) o1.value
                    / (double) o1.weight);
            double ratio2
                    = ((double) o2.value
                    / (double) o2.weight);
            return ratio1 < ratio2 ? 1 : -1;
        });

        double maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (w == 0) break;
            if (w - items[i].weight >= 0) {
                w -= items[i].weight;
                maxValue += items[i].value;
            } else {
                maxValue += (double) items[i].value * ((double) w / (double) items[i].weight);
                w = 0;
            }
        }
        return maxValue;
    }

    static class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Item items[] = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int n = items.length;

        int w = 50;

        System.out.println(maxCapacity(items, n, w)); // 240.0
    }
}
