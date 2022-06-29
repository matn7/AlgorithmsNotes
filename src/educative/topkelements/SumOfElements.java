package educative.topkelements;

import java.util.PriorityQueue;

public class SumOfElements {

    // O(nlog(n)) time | O(n) space
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        // remove k1 small numbers from min heap
        for (int i = 0; i < k1; i++) {
            minHeap.poll();
        }

        int elementSum = 0;

        for (int i = 0; i < k2 - k1 - 1; i++) {
            elementSum += minHeap.poll();
        }

        return elementSum;
    }

    // O(nlog(k2)) time | O(k2) space
    public static int findSumOfElements2(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int i = 0; i < nums.length; i++) {
            if (i < k2 - 1) {
                maxHeap.add(nums[i]);
            } else if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        int elementSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++) {
            elementSum += maxHeap.poll();
        }

        return elementSum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements2(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements2(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }

}
