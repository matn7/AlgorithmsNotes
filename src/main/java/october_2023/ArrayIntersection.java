package october_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {

    public static void main(String[] args) {
        int[] a = {4, 9, 5};
        int[] b = {9, 4, 9, 8, 4};

        List<Integer> result = arrayIntersection(a, b);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public static List<Integer> arrayIntersection(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Boolean> aElems = new HashMap<>();
        for (int num : a) {
            aElems.put(num, Boolean.TRUE);
        }

        for (int num : b) {
            if (aElems.containsKey(num) && !result.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

}
