package july_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    // O(n) time | O(1) space
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int n1 = -1;
        int n2 = -1;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (num == n1) {
                c1++;
            } else if (num == n2) {
                c2++;
            } else if (c1 == 0) {
                c1 = 1;
                n1 = num;
            } else if (c2 == 0) {
                c2 = 1;
                n2 = num;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == n1) {
                c1++;
            } else if (num == n2) {
                c2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (c1 > n / 3) {
            result.add(n1);
        }
        if (c2 > n / 3) {
            result.add(n2);
        }
        return result;
    }

    // O(n) time | O(n) space
    public List<Integer> majorityElement2(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> elem : freq.entrySet()) {
            if (elem.getValue() > n / 3) {
                result.add(elem.getKey());
            }
        }
        return result;
    }

}
