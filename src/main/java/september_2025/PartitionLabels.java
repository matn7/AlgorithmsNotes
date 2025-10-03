package september_2025;


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
        Map<Character, Integer> posMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            posMap.put(c, i);
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            end = Math.max(end, posMap.get(curr));
            count++;

            if (end == i) {
                result.add(count);
                count = 0;
            }
        }
        return result;
    }

}
