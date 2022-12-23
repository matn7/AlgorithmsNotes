package coderpro;

import java.util.*;

public class ArrayIntersection {

    public static void main(String[] args) {
        int[] a = {4, 9, 5};
        int[] b = {9, 4, 9, 8, 4};

        ArrayIntersection arrayIntersection = new ArrayIntersection();
        Set<Integer> result = arrayIntersection.arrayIntersection(a, b);
        System.out.println();

        List<Integer> nums1 = new ArrayList<>();
        for (int num : a) {
            nums1.add(num);
        }

        List<Integer> nums2 = new ArrayList<>();
        for (int num : b) {
            nums2.add(num);
        }

        Set<Integer> res2 = arrayIntersection.intersection2(nums1, nums2);
        System.out.println();
    }

    // O(n * m) space | O(n) space
    public Set<Integer> intersection(List<Integer> nums1, List<Integer> nums2) {
        Map<Integer, Boolean> results = new HashMap<>();
        for (int num : nums1) {
            if (nums2.contains(num) && !results.containsKey(num)) {
                results.put(num, Boolean.TRUE);
            }
        }
        return results.keySet();
    }

    // O(n + m) time | O(n + m) space
    public Set<Integer> intersection2(List<Integer> nums1, List<Integer> nums2) {
        Map<Integer, Boolean> hash = new HashMap<>();
        Map<Integer, Boolean> duplicates = new HashMap<>();

        for (int i : nums1) {
            hash.put(i, Boolean.TRUE);
        }

        for (int i : nums2) {
            if (hash.containsKey(i)) {
                duplicates.put(i, Boolean.TRUE);
            }
        }
        return duplicates.keySet();
    }

    // O(n + m) time | O(n + m) space
    public Set<Integer> arrayIntersection(int[] a, int[] b) {
        Map<Integer, Boolean> mapA = new HashMap<>();
        for (int num : a) {
            mapA.put(num, Boolean.TRUE);
        }
        Map<Integer, Boolean> resultMap = new HashMap<>();

        for (int num : b) {
            if (mapA.containsKey(num)) {
                resultMap.put(num, Boolean.TRUE);
            }
        }
        return resultMap.keySet();

    }

}
