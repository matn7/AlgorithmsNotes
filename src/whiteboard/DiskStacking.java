package whiteboard;

import java.util.*;
import java.util.stream.Collectors;

public class DiskStacking {

    public static void main(String[] args) {
        List<Integer[]> disks = new ArrayList<>();
        Integer[] disk1 = {2, 1, 2};
        Integer[] disk2 = {3, 2, 3};
        Integer[] disk3 = {2, 2, 8};
//        Integer[] disk4 = {2, 3, 4};
//        Integer[] disk5 = {1, 3, 1};
//        Integer[] disk6 = {4, 4, 5};

        disks.add(disk1);
        disks.add(disk2);
        disks.add(disk3);
//        disks.add(disk4);
//        disks.add(disk5);
//        disks.add(disk6);

        diskStacking(disks);
    }

    // O(n^2) time | O(n) space
    // #2: 25/06/2022
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Write your code here.
        Integer[] sequence = new Integer[disks.size()];
        Arrays.fill(sequence, null);
        Collections.sort(disks, Comparator.comparingInt(a -> a[2]));

        Integer[] heights = new Integer[disks.size()];
        int i = 0;
        for (Integer[] disk : disks) {
            heights[i] = disk[2];
            i++;
        }

        int maxHeightIdx = disks.size() - 1;
        // Corner case, disk itself the highest
        Integer maxHeight = disks.get(maxHeightIdx)[2];
        for (int idx = 0; idx < disks.size() - 1; idx++) {
            for (int j = idx + 1; j < disks.size(); j++) {
                Integer[] diskIdx = disks.get(idx);
                Integer[] disksJ = disks.get(j);

                if (compareDisks(disksJ, diskIdx)) {
                    int calculatedHeight = heights[idx] + disksJ[2];
                    if (calculatedHeight > heights[j]) {
                        heights[j] = calculatedHeight;
                        sequence[j] = idx;
                        maxHeightIdx = j;
                    }
                    System.out.println();
                }
            }
        }
        List<Integer[]> result = new ArrayList<>();
        if (heights[maxHeightIdx] < maxHeight) {
            result.add(disks.get(disks.size() - 1));
            return result;
        }


        buildSequence(maxHeightIdx, sequence, disks, result);

        Collections.reverse(result);

        return result;
    }

    private static void buildSequence(int maxHeightIdx, Integer[] sequence,
                                      List<Integer[]> disks, List<Integer[]> result) {
        Integer sequenceElement = maxHeightIdx;
        while (sequenceElement != null) {
            result.add(disks.get(sequenceElement));
            sequenceElement = sequence[sequenceElement];
        }
        System.out.println();
    }

    private static boolean compareDisks(Integer[] o, Integer[] c) {
        return o[0] > c[0] && o[1] > c[1] && o[2] > c[2];
    }

}
