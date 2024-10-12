package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfProducts {

    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2};
        ArrayOfProducts arrayOfProducts = new ArrayOfProducts();
        arrayOfProducts.arrayOfProducts(array);

        int[] nums = {1, 2, 3, 4, 6, 12};
        List<Integer> k = new ArrayList<>();
        for (int n : nums) {
            k.add(n);
        }

        arrayOfProducts.maxSubsetSum(k);
    }

//    // OK - repeated 18/02/2022
//    // O(n) time | O(n) space
//    public int[] arrayOfProducts(int[] array) {
//        int[] products = new int[array.length];
//        Arrays.fill(products, 1);
//        //             i
//        // products = [8, 40, 10, 20]
//        int leftRunningProduct = 1;
//        for (int i = 0; i < array.length; i++) {
//            products[i] = leftRunningProduct;
//            leftRunningProduct *= array[i]; // 2 * 20 = 40
//        }
//
//        int rightRunningProduct = 1;
//        for (int i = array.length - 1; i >= 0; i--) {
//            products[i] *= rightRunningProduct;
//            rightRunningProduct *= array[i]; // 8 * 5 = 40
//        }
//
//        return products; // [8, 40, 10, 20]
//    }

    public static List<Long> maxSubsetSum(List<Integer> k) {
        List<Long> result = new ArrayList<>();
        long[] leftFactors = new long[k.size()];
        long[] rightFactors = new long[k.size()];


        long leftRunning = 0L;
        for (int i = 0; i < k.size(); i++) {
            leftRunning += k.get(i);
            leftFactors[i] = leftRunning;
        }

        long rightRunning = 0L;
        for (int i = k.size() - 1; i >= 0; i--) {
            rightRunning += k.get(i);
            rightFactors[i] = rightRunning;
        }

        for (int i = 0; i < k.size(); i++) {
            result.add(leftFactors[i] + rightFactors[i]);
        }

        return result;
    }

    // O(n) time | O(n) space
    public int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];
        Arrays.fill(products, 1);
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        //             i
        // products = [8, 40, 10, 20]
        // leftProd = [1, 5, 5, 20]
        // rightPro = [8, 8, 2, 1]
        // array =    [5, 1, 4, 2]
        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i]; // 5 * 4 = 20
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i]; // 8 * 1 = 8
        }

        for (int i = 0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products; // [8, 40, 10, 20]
    }

//    // O(n^2) time | O(n) space
//    public int[] arrayOfProducts(int[] array) {
//        // Write your code here.
//        int[] products = new int[array.length];
//        Arrays.fill(products, 1);
//
//        //                        i
//        // products = [8, 40, 10, 20]
//        //                   j
//        // array =    [5, 1, 4, 2]
//        for (int i = 0; i < array.length; i++) {
//            int runningProduct = 1;
//            for (int j = 0; j < array.length; j++) {
//                if (i != j) {
//                    runningProduct *= array[j]; // 5 * 4 = 20
//                }
//            }
//            products[i] = runningProduct;
//        }
//        return products; // [8, 40, 10, 20]
//    }

}
