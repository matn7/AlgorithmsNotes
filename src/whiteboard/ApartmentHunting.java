package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {

    public static void main(String[] args) {
        String[] reqs = {"gym", "school", "store"};
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        Map<String, Boolean> block = new HashMap<>();
        block.put("gym", Boolean.FALSE);
        block.put("school", Boolean.TRUE);
        block.put("store", Boolean.FALSE);

        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym", Boolean.TRUE);
        block2.put("school", Boolean.FALSE);
        block2.put("store", Boolean.FALSE);

        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym", Boolean.TRUE);
        block3.put("school", Boolean.TRUE);
        block3.put("store", Boolean.FALSE);

        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("gym", Boolean.FALSE);
        block4.put("school", Boolean.TRUE);
        block4.put("store", Boolean.FALSE);

        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym", Boolean.FALSE);
        block5.put("school", Boolean.TRUE);
        block5.put("store", Boolean.TRUE);

        blocks.add(block);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);
        blocks.add(block5);

        apartmentHunting(blocks, reqs);
    }

    // O(b^2 * r) time | O(1) space
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        if (blocks.isEmpty()) {
            return -1;
        }
//        int[] distance = new int[blocks.size()];
        int minIdx = 0;
        int apartmentMinDistance = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.size(); i++) {
            int currentMax = 0;
            for (String req : reqs) {
                int currentMin = Integer.MAX_VALUE;
                for (int j = 0; j < blocks.size(); j++) {
                    Map<String, Boolean> currentBlock = blocks.get(j);
                    if (!currentBlock.containsKey(req)) {
                        continue;
                    }
                    if (currentBlock.get(req)) {
                        currentMin = Math.min(currentMin, Math.abs(i - j));
                    }
                }
                currentMax = Math.max(currentMax, currentMin);
            }
//            distance[i] = currentMax;
            if (currentMax < apartmentMinDistance) {
                apartmentMinDistance = currentMax;
                minIdx = i;
            }
        }
        return minIdx;
    }

}
