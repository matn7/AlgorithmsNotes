package december_2024;

import java.util.*;

public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> integers = partitionLabels.partitionLabels(s);
        System.out.println(integers);
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            positionMap.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int size = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, positionMap.get(c));
            size++;
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }


}
