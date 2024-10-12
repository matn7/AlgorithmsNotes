package march_2024;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 1, 1};

        int result = majorityElement(elements);
        System.out.println(result);

        int result2 = majorityElement2(elements);
        System.out.println(result2);
    }

    // O(n) time | O(1) space
    public static int majorityElement(int[] elements) {

        // [1, 2, 3, 1, 1]
        //              *
        //  r = 2
        //  f = 1
        int result = elements[0];
        int freq = 1;

        for (int i = 1; i < elements.length; i++) {
            int curr = elements[i];
            if (curr == result) {
                freq++;
            } else {
                freq--;
                if (freq == 0) {
                    result = curr;
                    freq = 1;
                }
            }
        }

        return result;
    }

    // O(n) time | O(n) space
    public static int majorityElement2(int[] elements) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = elements.length;

        for (int num : elements) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int majorityElement = 0;
        for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
            Integer value = elem.getValue();
            if (value > length / 2) {
                majorityElement = elem.getKey();
                break;
            }
        }
        return majorityElement;
    }

}






















