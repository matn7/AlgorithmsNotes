package june_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> result = partitionLabels.partitionLabels(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIdx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIdx.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIdx.get(s.charAt(i)));
            size++;
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }

}
