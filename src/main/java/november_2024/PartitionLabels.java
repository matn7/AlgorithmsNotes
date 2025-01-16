package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> integers = partitionLabels.partitionLabels(s);
        System.out.println(integers);
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
        }
        int size = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            size++;
            Integer lastIndex = indexMap.get(c);
            end = Math.max(lastIndex, end);
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }

}
