package january_2026;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] result = intersectionOfTwoArrays.intersect(nums1, nums2);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap1 = new HashMap<>();
        Map<Integer, Integer> freqMap2 = new HashMap<>();

        for (int num : nums1) {
            freqMap1.put(num, freqMap1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> element : freqMap1.entrySet()) {
            int key = element.getKey();
            if (freqMap2.containsKey(key)) {
                int val1 = element.getValue();
                int val2 = freqMap2.get(key);
                for (int i = 0; i < Math.min(val1, val2); i++) {
                    result.add(key);
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

}
