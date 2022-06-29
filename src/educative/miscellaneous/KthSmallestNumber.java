package educative.miscellaneous;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthSmallestNumber {

    // O(n) time | O(n) space
    public static int findKthSmallestNumber(int[] nums, int k) {
        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
    }

    public static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {
        int p = partition(nums, start, end);

        if (p == k - 1)
            return nums[p];

        if (p > k - 1) // search the lower part
            return findKthSmallestNumberRec(nums, k, start, p - 1);

        // search the higher part
        return findKthSmallestNumberRec(nums, k, p + 1, end);
    }

    private static int partition(int[] nums, int low, int high) {
        if (low == high)
            return low;

        int median = medianOfMedians(nums, low, high);
        // find the median in the array and swap it with 'nums[high]' which will become our pivot
        for (int i = low; i < high; i++) {
            if (nums[i] == median) {
                swap(nums, i, high);
                break;
            }
        }

        int pivot = nums[high];
        for (int i = low; i < high; i++) {
            // all elements less than 'pivot' will be before the index 'low'
            if (nums[i] < pivot)
                swap(nums, low++, i);
        }
        // put the pivot in its correct place, remember nums[high] is our pivot
        swap(nums, low, high);
        return low;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int medianOfMedians(int[] nums, int low, int high) {
        int n = high - low + 1;
        // if we have less than 5 elements, ignore the partitioning algorithm
        if (n < 5)
            return nums[low];

        // for simplicity, lets ignore any partition with less than 5 elements
        int numOfPartitions = n / 5; // represents total number of 5 elements partitions
        int[] medians = new int[numOfPartitions];
        for (int i = 0; i < numOfPartitions; i++) {
            int partitionStart = low + i * 5; // starting index of the current partition
            Arrays.sort(nums, partitionStart, partitionStart + 5); // sort the 5 elements array
            medians[i] = nums[partitionStart + 2]; // get the middle element (or the median)
        }

        return partition(medians, 0, numOfPartitions - 1);
    }

//    // O()n^2) time | O(n) space
//    public static int findKthSmallestNumber(int[] nums, int k) {
//        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
//    }
//
//    public static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {
//        int p = partition(nums, start, end);
//
//        if (p == k - 1)
//            return nums[p];
//
//        if (p > k - 1) // search lower part
//            return findKthSmallestNumberRec(nums, k, start, p - 1);
//
//        // search higher part
//        return findKthSmallestNumberRec(nums, k, p + 1, end);
//    }
//
//    private static int partition(int[] nums, int low, int high) {
//        if (low == high)
//            return low;
//
//        Random randomNum = new Random();
//        int pivotIndex = low + randomNum.nextInt(high - low);
//        swap(nums, pivotIndex, high);
//
//        int pivot = nums[high];
//        for (int i = low; i < high; i++) {
//            // all elements less than 'pivot' will be before the index 'low'
//            if (nums[i] < pivot)
//                swap(nums, low++, i);
//        }
//        // put the pivot in its correct place
//        swap(nums, low, high);
//        return low;
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

//    // O(nlog(n)) time | O(n) space
//    public static int findKthSmallestNumber(int[] nums, int k) {
//        return findKthSmallestNumberRec(nums, k, 0, nums.length - 1);
//    }
//
//    public static int findKthSmallestNumberRec(int[] nums, int k, int start, int end) {
//        int p = partition(nums, start, end);
//
//        if (p == k - 1)
//            return nums[p];
//
//        if (p > k - 1) // search lower part
//            return findKthSmallestNumberRec(nums, k, start, p - 1);
//
//        // search higher part
//        return findKthSmallestNumberRec(nums, k, p + 1, end);
//    }
//
//    private static int partition(int[] nums, int low, int high) {
//        if (low == high)
//            return low;
//
//        int pivot = nums[high];
//        for (int i = low; i < high; i++) {
//            // all elements less than 'pivot' will be before the index 'low'
//            if (nums[i] < pivot)
//                swap(nums, low++, i);
//        }
//        // put the pivot in its correct place
//        swap(nums, low, high);
//        return low;
//    }
//
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//

//    // O(nlog(k)) time | O(k) space
//    public static int findKthSmallestNumber(int[] nums, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
//        // put first k numbers in the max heap
//        for (int i = 0; i < k; i++)
//            maxHeap.add(nums[i]);
//
//        // go through the remaining numbers of the array, if the number from the array is smaller than the
//        // top (biggest) number of the heap, remove the top number from heap and add the number from array
//        for (int i = k; i < nums.length; i++) {
//            if (nums[i] < maxHeap.peek()) {
//                maxHeap.poll();
//                maxHeap.add(nums[i]);
//            }
//        }
//
//        // the root of the heap has the Kth smallest number
//        return maxHeap.peek();
//    }

//    // O(nlog(n)) time | O(1) space
//    public static int findKthSmallestNumber(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[k - 1];
//    }

//    // O(n * k) time | O(1) space
//    public static int findKthSmallestNumber(int[] nums, int k) {
//        int previousSmallestNum = Integer.MIN_VALUE;
//        int previousSmallestIndex = -1;
//        int currentSmallestNum = Integer.MAX_VALUE;
//        int currentSmallestIndex = -1;
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] > previousSmallestNum && nums[j] < currentSmallestNum) {
//                    // found the next smallest number
//                    currentSmallestNum = nums[j];
//                    currentSmallestIndex = j;
//                } else if (nums[j] == previousSmallestNum && j > previousSmallestIndex) {
//                    // found a number which is equal to the previous smallest number; since numbers can repeat,
//                    // we will consider 'nums[j]' only if it has a different index than previous smallest
//                    currentSmallestNum = nums[j];
//                    currentSmallestIndex = j;
//                    break; // break here as we have found our definitive next smallest number
//                }
//            }
//            // current smallest number becomes previous smallest number for the next iteration
//            previousSmallestNum = currentSmallestNum;
//            previousSmallestIndex = currentSmallestIndex;
//            currentSmallestNum = Integer.MAX_VALUE;
//        }
//
//        return previousSmallestNum;
//    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
