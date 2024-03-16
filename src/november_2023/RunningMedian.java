package november_2023;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 7, 2, 0, 5};

        RunningMedian runningMedian = new RunningMedian();
        double[] result = runningMedian.runningMedian(nums);
        System.out.println(result);
    }

    PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> higher = new PriorityQueue<>();

    // O(nlog(n)) time | O(n) space
    public double[] runningMedian(int[] nums) {
        double[] result = new double[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            insert(num);
            rebalance();
            double median = calcmedian();
            result[i] = median;
        }

        return result;
    }

    private void insert(int num) {
        if (lower.isEmpty()) {
            lower.add(num);
        } else {
            Integer peek = lower.peek();
            if (num > peek) {
                higher.add(num);
            } else {
                lower.add(num);
            }
        }
    }

    private void rebalance() {
        if (lower.size() - higher.size() >= 2) {
            higher.add(lower.poll());
        } else if (higher.size() - lower.size() >= 2) {
            lower.add(higher.poll());
        }
    }

    private double calcmedian() {
        if (lower.size() > higher.size()) {
            return lower.peek();
        } else if (higher.size() > lower.size()) {
            return higher.peek();
        } else {
            return (lower.peek() + higher.peek()) / 2.0;
        }
    }
}
