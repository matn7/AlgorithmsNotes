package october_2025;

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

    // O(n) time | O(26) space
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastCharPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastCharPos.put(c, i);
        }
        int count = 0;
        int maxPos = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            maxPos = Math.max(maxPos, lastCharPos.get(c));
            count++;
            if (maxPos == i) {
                result.add(count);
                count = 0;
            }
        }
        return result;
    }


}
