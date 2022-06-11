package whiteboard;

import java.util.List;

public class ProductSum {

    // O(n) time | O(d) space
    public static int productSum(List<Object> array) {
        // Write your code here.
        return productSumHelper(array, 1);
    }

    private static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object element : array) {
            if (element instanceof List) {
                sum += productSumHelper((List<Object>) element, multiplier + 1);
            } else {
                sum = sum + (Integer) element;
            }
        }

        return sum * multiplier;
    }

}
