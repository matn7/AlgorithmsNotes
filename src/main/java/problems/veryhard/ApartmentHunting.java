package problems.veryhard;

import java.util.*;

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


    // O(br) time | O(br) space
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        List<Map<String, List<Integer>>> minDistancesFromBlocks = new ArrayList<>();
        for (Map<String, Boolean> block : blocks) {
            for (String req : reqs) {
                Map<String, List<Integer>> element = new HashMap<>();
                element.put(req, getMinDistances(blocks, req));
                minDistancesFromBlocks.add(element);
            }
        }

        List<Integer> maxDistancesAtBlocks = getMaxDistancesAtBlocks(blocks, minDistancesFromBlocks);
        return getIdxAtMinValue(maxDistancesAtBlocks);
    }

    private static List<Integer> getMinDistances(List<Map<String, Boolean>> blocks, String req) {
        List<Integer> minDistances = new ArrayList<>();
        for (Map<String, Boolean> element : blocks) {
            minDistances.add(0);
        }
        int closestReqIdx = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(req)) {
                closestReqIdx = i;
            }
            minDistances.set(i, distanceBetween(i, closestReqIdx));
        }
        for (int i = blocks.size() - 1; i >= 0; i--) {
            if (blocks.get(i).get(req)) {
                closestReqIdx = i;
            }
            minDistances.set(i, Math.min(minDistances.get(i), distanceBetween(i, closestReqIdx)));
        }
        return minDistances;
    }


    private static List<Integer> getMaxDistancesAtBlocks(List<Map<String, Boolean>> blocks,
                                                         List<Map<String, List<Integer>>> minDistancesFromBlocks) {
        List<Integer> maxDistancesAtBlocks = new ArrayList<>();
        for (Map<String, Boolean> block : blocks) {
            maxDistancesAtBlocks.add(0);
        }

        for (int i = 0; i < blocks.size(); i++) {
            Collection<List<Integer>> minDistancesAtBlock = minDistancesFromBlocks.get(i).values();
            int max = Integer.MIN_VALUE;
            for (List<Integer> currentMax : minDistancesAtBlock) {
                if (currentMax.get(i) > max) {
                    max = currentMax.get(i);
                }
            }
            maxDistancesAtBlocks.set(i, max);
        }
        return maxDistancesAtBlocks;
    }

    private static int getIdxAtMinValue(List<Integer> array) {
        int idxAtMinValue = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            int currentValue = array.get(i);
            if (currentValue < minValue) {
                minValue = currentValue;
                idxAtMinValue = i;
            }
        }
        return idxAtMinValue;
    }


    // OK - repeated 19/02/2022
    // O(b^2 * r) time | O(b) space
    public static int apartmentHunting2(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
//
//                                                                                i
// [{               {                 {                 {                 {
//    gym: FALSE,     gym: TRUE,        gym: TRUE,        gym: FALSE,       gym: FALSE,
//    school: TRUE,   school: FALSE,    school: TRUE      school: TRUE      school: TRUE,
//    store: FALSE    store: FALSE      store: FALSE      store: FALSE      store: TRUE     *
// },                },               },                },                }]
//                                                                                j
        int[] maxDistancesAtBlocks = new int[blocks.size()];
        // maxDistancesAtBlocks = [0, 0, 0, 0, 0]
        Arrays.fill(maxDistancesAtBlocks, Integer.MIN_VALUE);
        // maxDistancesAtBlocks = [4, 3, 2, 1, 2]
        //                               *
        // reqs = ["gym", "school", "store"]
        for (int i = 0; i < blocks.size(); i++) {
            for (String req : reqs) {
                int closestReqDistance = Integer.MAX_VALUE; // 999
                for (int j = 0; j < blocks.size(); j++) {
                    if (blocks.get(j).get(req)) { // TRUE
                        closestReqDistance = Math.min(closestReqDistance, distanceBetween(i, j)); // min(999,0) = 0
                    }
                }
                maxDistancesAtBlocks[i] = Math.max(maxDistancesAtBlocks[i], closestReqDistance); // max(2,0) = 2
            }
        }

        return getIdxAtMinValue(maxDistancesAtBlocks);
    }
    //                  *
    // rec([4, 3, 2, 1, 2])
    private static int getIdxAtMinValue(int[] array) {
        int idxAtMinValue = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i]; // 2
            if (currentValue < minValue) { // 2 < 1
                minValue = currentValue; // 1
                idxAtMinValue = i; // 3
            }
        }
        return idxAtMinValue; // 3
    }

    private static int distanceBetween(int a, int b) {
        return Math.abs(a - b);
    }

}
