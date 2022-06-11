package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiskStackingREPEAT {

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
    // OK - repeated 05/02/2022
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Write your code here.
        // [[2,2,1],[2,1,2],[3,2,3],[2,3,4],[4,4,5],[2,2,8]
        Collections.sort(disks, Comparator.comparingInt(a -> a[2])); // idx 2 height
        // [    1,      2,      3,      4,      5,      8]
        List<Integer> heights = new ArrayList<>(); // []
        List<Integer> sequences = new ArrayList<>(); // []
        for (Integer[] disk : disks) {
            heights.add(disk[2]);
            sequences.add(null);
        }
        // heights = [1, 2, 5, 4, 10, 8]
        // sequences = [null, null, 1, null, 2, null]
        //     0       1       2       3       4       5
        // [[2,2,1],[2,1,2],[3,2,3],[2,3,4],[4,4,5],[2,2,8]
        //     o                                       c
        int maxHeightIdx = 0;
        // can we stack other disk into current
        for (int i = 1; i < disks.size(); i++) {
            Integer[] currentDisk = disks.get(i); // [2,2,8]
            for (int j = 0; j < i; j++) {
                Integer[] otherDisk = disks.get(j); // [4,4,5]
                if (areValidDimensions(otherDisk, currentDisk)) {
                    // 10 <= 5 + 4
                    if (heights.get(i) <= currentDisk[2] + heights.get(j)) {
                        heights.set(i, currentDisk[2] + heights.get(j));
                        sequences.set(i, j);
                    }
                }
            }
            if (heights.get(i) >= heights.get(maxHeightIdx)) {
                maxHeightIdx = i; // 4
            }
        }

        return buildSequence(disks, sequences, maxHeightIdx);
    }

    private static List<Integer[]> buildSequence(List<Integer[]> array, List<Integer> sequences, Integer currentIdx) {
        List<Integer[]> sequence = new ArrayList<>();
        // sequences = [null, null, 1, null, 2, null]
        // currentIdx = 4
        while (currentIdx != null) {
            sequence.add(array.get(currentIdx)); // [[4,4,5],[3,2,3],[2,1,2]]
            currentIdx = sequences.get(currentIdx); // 1
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static boolean areValidDimensions(Integer[] o, Integer[] c) {
        // o = [2,1,2]
        // c = [3,2,3]
        return o[0] < c[0] && o[1] < c[1] && o[2] < c[2];
    }

}
