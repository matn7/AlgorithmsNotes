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
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Write your code here.
        Collections.sort(disks, Comparator.comparingInt(a -> a[2]));
        List<Integer> heights = new ArrayList<>();
        for (Integer[] disk : disks) {
            heights.add(disk[2]);
        }
        List<Integer> sequences = new ArrayList<>();
        for (Integer[] disk : disks) {
            sequences.add(null);
        }
        int maxHeightIdx = 0;
        for (int i = 1; i < disks.size(); i++) {
            Integer[] currentDisk = disks.get(i);
            for (int j = 0; j < i; j++) {
                Integer[] otherDisk = disks.get(j);
                if (areValidDimensions(otherDisk, currentDisk)) {
                    if (heights.get(i) <= currentDisk[2] + heights.get(j)) {
                        heights.set(i, currentDisk[2] + heights.get(j));
                        sequences.set(i, j);
                    }
                }
            }
            if (heights.get(i) >= heights.get(maxHeightIdx)) {
                maxHeightIdx = i;
            }
        }
        return buildSequence(disks, sequences, maxHeightIdx);
    }

    private static List<Integer[]> buildSequence(List<Integer[]> disks, List<Integer> sequences, Integer currentIdx) {
        List<Integer[]> sequence = new ArrayList<>();
        while (currentIdx != null) {
            sequence.add(disks.get(currentIdx));
            currentIdx = sequences.get(currentIdx);
        }
        // [bottom disk, secondBottom, thirdBottom, ... ]
        List<Integer[]> result = new ArrayList<>();
        int index = sequence.size() - 1;
        for (Integer[] element : sequence) {
            result.add(sequence.get(index));
            index--;
        }
        return result;
    }

    private static boolean areValidDimensions(Integer[] o, Integer[] c) {
        return o[0] < c[0] && o[1] < c[1] && o[2] < c[2];
    }
}
