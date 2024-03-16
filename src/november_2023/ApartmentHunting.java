package november_2023;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class ApartmentHunting {

    public static void main(String[] args) {
        List<Map<String, Boolean>> apartments = new ArrayList<>();
        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("gym", Boolean.FALSE);
        block1.put("school", Boolean.TRUE);
        block1.put("store", Boolean.FALSE);

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

        apartments.add(block1);
        apartments.add(block2);
        apartments.add(block3);
        apartments.add(block4);
        apartments.add(block5);

        String[] reqs = {"gym", "school", "store"};

        apartmentHunting(apartments, reqs);
    }

    // O(r * n^2) time | O(n) space
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        int[] distances = new int[blocks.size()];
        Arrays.fill(distances, Integer.MIN_VALUE);
        for (String req : reqs) {
            for (int i = 0; i < blocks.size(); i++) {
                int currBlockMinDistance = Integer.MAX_VALUE;
                for (int j = 0; j < blocks.size(); j++) {
                    Map<String, Boolean> block = blocks.get(j);
                    if (block.get(req)) {
                        int currDistance = Math.abs(j - i);
                        currBlockMinDistance = Math.min(currDistance, currBlockMinDistance);
                    }
                }
                distances[i] = Math.max(distances[i], currBlockMinDistance);
            }
            System.out.println();
        }
        int minIdx = 0;
        int minVal = distances[minIdx];
        for (int i = 1; i < distances.length; i++) {
            int currVal = distances[i];
            if (currVal < minVal) {
                minVal = currVal;
                minIdx = i;
            }
        }

        return minIdx;
    }

}
