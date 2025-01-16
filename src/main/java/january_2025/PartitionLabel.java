package january_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {

    public static void main(String[] args) {
        String s = "xyxxyzbzbbisl";

        PartitionLabel partitionLabel = new PartitionLabel();
        List<Integer> result = partitionLabel.partitionLabels(s);
        System.out.println(result);
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charsMap.put(c, i);
        }
        List<Integer> result = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, charsMap.get(c));
            size++;
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }

}
