package com.cb.greedy;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 * O(n*n)
 * Greedy
 * */
public class G2_JobSequencingProblem {
    private static void arrange(Job[] arr, int n) {

        // sort (desc) by profit
        Arrays.sort(arr, (o1, o2) -> o2.profit - o1.profit);

        // calculating max deadline to initialize slots
        int maxDeadline = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline)
                maxDeadline = arr[i].deadline;
        }

        // fill available slots
        String[] slots = new String[maxDeadline];
        for (int i = 0; i < n; i++) {
            Job job = arr[i];
            int j = job.deadline - 1;
            while (j >= 0) {
                if (slots[j] == null) {
                    slots[j] = job.jobId;
                    break;
                }
                j--;
            }
        }

        // print selected jobs
        System.out.println(Arrays.stream(slots).filter(Objects::nonNull).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) {
        Job[] jobs = {new Job("a", 4, 20),
                new Job("b", 1, 10),
                new Job("c", 1, 40),
                new Job("d", 1, 30)};
        arrange(jobs, 4);

        Job[] jobs1 = {new Job("a", 2, 100),
                new Job("b", 1, 19),
                new Job("c", 2, 27),
                new Job("d", 1, 25),
                new Job("e", 3, 15)
        };
        arrange(jobs1, 5);
    }

    private static class Job {
        String jobId;
        int deadline;
        int profit;

        public Job(String jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
}
