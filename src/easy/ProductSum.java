package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

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

        productSum(array);

    }

    // O(n) time (n total number included in subarray) | O(d) space (d depth of subarray)
    public static int productSum(List<Object> array) {
        // Write your code here.
        int result = productSumHelper(array, 1);
        return result;
    }

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
