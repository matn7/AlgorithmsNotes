package veryhard;

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

//    // O(br) time | O(br) space
//    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
//        // Write your code here.
//        List<Map<String, List<Integer>>> minDistancesFromBlocks = new ArrayList<>();
//        for (Map<String, Boolean> block : blocks) {
//            for (String req : reqs) {
//                Map<String, List<Integer>> maciek = new HashMap<>();
//                maciek.put(req, getMinDistances(blocks, req));
//                minDistancesFromBlocks.add(maciek);
//            }
//        }
//
//        List<Integer> maxDistancesAtBlocks = getMaxDistancesAtBlocks(blocks, minDistancesFromBlocks);
//        return getIdxAtMinValue(maxDistancesAtBlocks);
//    }
//
//    private static int getIdxAtMinValue(List<Integer> array) {
//        int idxAtMinValue = 0;
//        int minValue = Integer.MAX_VALUE;
//        for (int i = 0; i < array.size(); i++) {
//            int currentValue = array.get(i);
//            if (currentValue < minValue) {
//                minValue = currentValue;
//                idxAtMinValue = i;
//            }
//        }
//        return idxAtMinValue;
//    }
//
//    private static List<Integer> getMaxDistancesAtBlocks(List<Map<String, Boolean>> blocks,
//                                                         List<Map<String, List<Integer>>> minDistancesFromBlocks) {
//        List<Integer> maxDistancesAtBlocks = new ArrayList<>();
//        for (Map<String, Boolean> block : blocks) {
//            maxDistancesAtBlocks.add(0);
//        }
//
//        for (int i = 0; i < blocks.size(); i++) {
//            Collection<List<Integer>> minDistancesAtBlock = minDistancesFromBlocks.get(i).values();
//            int max = Integer.MIN_VALUE;
//            for (List<Integer> currentMax : minDistancesAtBlock) {
//                if (currentMax.get(i) > max) {
//                    max = currentMax.get(i);
//                }
//            }
//            maxDistancesAtBlocks.set(i, max);
//        }
//        return maxDistancesAtBlocks;
//    }
//
//    private static List<Integer> getMinDistances(List<Map<String, Boolean>> blocks, String req) {
//        List<Integer> minDistances = new ArrayList<>();
//        for (Map<String, Boolean> block : blocks) {
//            minDistances.add(0);
//        }
//        int closestReqIdx = Integer.MAX_VALUE;
//        for (int i = 0; i < blocks.size(); i++) {
//            if (blocks.get(i).get(req)) {
//                closestReqIdx = i;
//            }
//            minDistances.set(i, distanceBetween(i, closestReqIdx));
//        }
//        for (int i = blocks.size() - 1; i >= 0; i--) {
//            if (blocks.get(i).get(req)) {
//                closestReqIdx = i;
//            }
//            minDistances.set(i, Math.min(minDistances.get(i), distanceBetween(i, closestReqIdx)));
//        }
//        return minDistances;
//    }
//
//    private static int distanceBetween(int a, int b) {
//        return Math.abs(a - b);
//    }

    // O(b^2*r) time (b blocks, r reqs) | O(b) space
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        List<Integer> maxDistancesAtBlocks = new ArrayList<>();
        for (int block = 0; block < blocks.size(); block++) {
            maxDistancesAtBlocks.add(Integer.MIN_VALUE);
        }

        for (int i = 0; i < blocks.size(); i++) {
            for (String req : reqs) {
                int closestReqDistance = Integer.MAX_VALUE;
                for (int j = 0; j < blocks.size(); j++) {
                    if (blocks.get(j).get(req)) {
                        closestReqDistance = Math.min(closestReqDistance, distanceBetween(i, j));
                    }
                }
                maxDistancesAtBlocks.set(i, Math.max(maxDistancesAtBlocks.get(i), closestReqDistance));
            }
        }

        return getIdxAtMinValue(maxDistancesAtBlocks);
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

    private static int distanceBetween(int a, int b) {
        return Math.abs(a - b);
    }

}
