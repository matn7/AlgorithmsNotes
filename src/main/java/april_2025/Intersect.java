package april_2025;

import java.util.*;

public class Intersect {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};

//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9, 4, 9, 8, 4};

        int[] nums1 = {1, 2};
        int[] nums2 = {1, 1};

        Intersect intersect = new Intersect();
        int[] result = intersect.intersect(nums1, nums2);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();

        for (int num : nums1) {
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            nums2Map.put(num, nums2Map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> element : nums1Map.entrySet()) {
            int key = element.getKey();
            int value = element.getValue();
            if (nums2Map.containsKey(key)) {
                int min = Math.min(value, nums2Map.get(key));
                for (int i = 0; i < min; i++) {
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
