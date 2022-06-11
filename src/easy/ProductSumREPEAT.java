package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSumREPEAT {

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        List<Object> elem1 = new ArrayList<>(Arrays.asList(7,-1));
        array.add(elem1);
        array.add(3);
        List<Object> elem2 = new ArrayList<>();
        elem2.add(6);
        List<Object> elem22 = new ArrayList<>(Arrays.asList(-13, 8));
        elem2.add(elem22);
        elem2.add(4);
        array.add(elem2);

        // [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
        productSum(array);

    }

    // OK - repeated 04/03/2022
    // rec([5, 2, [7, -1], 3, [6, [-13, 8], 4]])
    // O(n) time (n total number included in subarray) | O(d) space (d depth of subarray)
    public static int productSum(List<Object> array) {
        // Write your code here.
        int result = productSumHelper(array, 1);
        return result;
    }


    // rec([-13, 8], 3) => -5 * 3 = -15
    // rec([6, [-13, 8], 4]], 2) => (6 + (-15) + 4 ) * 2 = -10
    // rec([7, -1], 2) => 6 * 2 = 12
    // rec([5, 2, [7, -1], 3, [6, [-13, 8], 4]], 1) => (11 + 12 + (-10)) = 12
    //                                           *
    public static int productSumHelper(List<Object> array, int multiplier) {
        // Write your code here.
        int sum = 0;
        for (Object element : array) { // 8
            if (element instanceof ArrayList) {
                sum += productSumHelper((List<Object>) element, multiplier + 1);
            } else {
                sum += (int) element; // -5
            }
        }
        return sum * multiplier;
    }

}
