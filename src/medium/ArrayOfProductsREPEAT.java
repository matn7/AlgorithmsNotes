package medium;

import java.util.Arrays;

public class ArrayOfProductsREPEAT {

    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2};
        ArrayOfProductsREPEAT arrayOfProductsREPEAT = new ArrayOfProductsREPEAT();
        arrayOfProductsREPEAT.arrayOfProducts(array);
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
