package june_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabel partitionLabel = new PartitionLabel();
        List<Integer> result = partitionLabel.partitionLabels(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            seen.put(c, i);
        }

        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, seen.get(s.charAt(i)));

            if (i == end) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }

}
