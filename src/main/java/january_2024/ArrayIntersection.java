package january_2024;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;

public class ArrayIntersection {

    public static void main(String[] args) {
        int[] a = {4, 9, 5};
        int[] b = {9, 4, 9, 8, 4};

        List<Integer> integers = arrayIntersection(a, b);
        System.out.println(integers);
        System.out.println(arrayIntersection2(a, b));
    }

    // O(n + m) time | O(m) space
    public static List<Integer> arrayIntersection(int[] a, int[] b) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : a) {
            seen.add(num);
        }

        for (int num : b) {
            if (seen.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    // O(n + m) time | O(m) space
    public static Set<Integer> arrayIntersection2(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        Map<Integer, Integer> duplicates = new HashMap();

        for (int num : nums1) {
            hash.put(num, 1);
        }

        for (int num : nums2) {
            if (hash.containsKey(num)) {
                duplicates.put(num, 1);
            }
        }

        return duplicates.keySet();
    }

}
