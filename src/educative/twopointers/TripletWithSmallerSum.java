package educative.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum {

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

        System.out.println(TripletWithSmallerSum.searchTriplets2(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets2(new int[] { -1, 4, 2, 1, 3 }, 5));
    }

    // O(n^2) time | O(n) space
    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    // O(n^3) time | O(n) space
    public static List<List<Integer>> searchTriplets2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            searchPair(arr, target - arr[i], i, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
        int left = first + 1;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                for (int i = right; i > left; i--) {
                    triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
                }
                left++;
            } else {
                right--;
            }
        }
    }

}
