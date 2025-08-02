package july_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel2 {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabel2 partitionLabel2 = new PartitionLabel2();
        List<Integer> result = partitionLabel2.partitionLabels(s);
        System.out.println(result);
    }

    // Intuition:
    // - find idx of occurrences of chars
    // - where/when to split, reset size?
    // - greedy
    // Approach:
    // - charsMap
    // - idx which check current sequence end
    // - if idx in charsMap met with end reset new sequence
    // Complexity:
    // O(n) time | O(n) space
    // Code:

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charsMap.put(c, i);
        }
        int size = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            size++;
            end = Math.max(end, charsMap.get(c));

            if (i == end) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }

}
