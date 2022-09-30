package com.cb.greedy;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * O(n log n) - for unsorted
 * O(n) for sorted by 'finish'
 * Greedy
 * */
public class GR1_ActivitySelectionProblem {

    private static void selectActivities(Activity[] arr, int n) {
        if (arr == null || n < 1) return;

        // sort by finish time
        Arrays.sort(arr, (s1, s2) -> s1.finish - s2.finish);

        // the first activity always gets selected
        System.out.print("Selected activities: " + arr[0]);

        int currentFinish = arr[0].finish;

        // consider rest of the activities
        for (int i = 1; i < n; i++) {
            if (arr[i].start >= currentFinish) {
                System.out.print(" ," + arr[i]);
                currentFinish = arr[i].finish;
            }
        }
    }

    public static void main(String[] args) {
        var input = new Activity[]{new Activity(1, 5), new Activity(2, 7), new Activity(6, 7), new Activity(
                8,
                11), new Activity(8, 9)};
        System.out.println(Arrays.stream(input).map(i -> i.toString()).collect(Collectors.joining(",")));
        selectActivities(input, 5);
    }

    private static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "(" + start + "," + finish + ")";
        }
    }
}
