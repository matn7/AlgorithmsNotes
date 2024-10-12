package problems.hard;

import java.util.*;

public class DiskStacking {

    public static void main(String[] args) {
        List<Integer[]> disks = new ArrayList<>();
        Integer[] element1 = {2, 2, 1};
        Integer[] element2 = {2, 1, 2};
        Integer[] element3 = {3, 2, 3};
        Integer[] element4 = {2, 3, 4};
        Integer[] element5 = {4, 4, 5};
        Integer[] element6 = {2, 2, 8};

        disks.add(element1);
        disks.add(element2);
        disks.add(element6);
        disks.add(element3);
        disks.add(element4);
        disks.add(element5);

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
