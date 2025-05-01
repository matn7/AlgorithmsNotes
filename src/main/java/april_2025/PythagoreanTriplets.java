package april_2025;

import java.util.HashSet;
import java.util.Set;

public class PythagoreanTriplets {

    public static void main(String[] args) {
        int[] nums = {3, 5, 12, 5, 13};

        PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets();
        boolean result = pythagoreanTriplets.findTriplets(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public boolean findTriplets(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Set<Integer> squares = new HashSet<>();
        for (int a = 0; a < nums.length; a++) {
            int numA = nums[a];
            for (int b = a + 1; b < nums.length; b++) {
                int numB = nums[b];
                squares.add(numA * numA + numB * numB);
            }
        }

        for (int c = 2; c < nums.length; c++) {
            int numC = nums[c];
            int square = numC * numC;
            if (squares.contains(square)) {
                return true;
            }
        }

        return false;
    }

    // O(n^3) time | O(1) space
    public boolean findTriplets2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        for (int a = 0; a < nums.length; a++) {
            int numA = nums[a];
            for (int b = a + 1; b < nums.length; b++) {
                int numB = nums[b];
                for (int c = b + 1; c < nums.length; c++) {
                    int numC = nums[c];
                    if (numA * numA + numB * numB == numC * numC) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



}
