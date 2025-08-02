package july_2025;

import august_2024.FrequentSubtree;

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
        Map<Character, Integer> charsPos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charsPos.put(c, i);
        }
        List<Integer> result = new ArrayList<>();
        int end = 0;
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            size++;
            end = Math.max(end, charsPos.get(c));

            if (end == i) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }


}
