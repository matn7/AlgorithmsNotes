package november_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        List<Object> arr1 = new ArrayList<>();
        arr1.add(7);
        arr1.add(-1);
        array.add(arr1);
        array.add(3);
        List<Object> arr2 = new ArrayList<>();
        arr2.add(6);
        List<Object> arr3 = new ArrayList<>();
        arr3.add(-13);
        arr3.add(8);
        arr2.add(arr3);
        arr2.add(4);
        array.add(arr2);

        int result = productSum(array);
        System.out.println(result);
    }

    // O(n) time | O(d) space
    public static int productSum(List<Object> array) {
        if (array.isEmpty()) {
            return 0;
        }

        return productSumHelper(array, 1);
    }

    private static int productSumHelper(List<Object> array, int multiply) {
        int sum = 0;

        for (Object element : array) {
            if (element instanceof ArrayList<?>) {
                sum += productSumHelper((List<Object>) element, multiply + 1);
            } else {
                sum += (Integer) element;
            }
        }

        return sum * multiply;
    }

}
