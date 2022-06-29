package whiteboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiskStacking2 {

    public static void main(String[] args) {
        List<Integer[]> disks = new ArrayList<>();
        Integer[] disk1 = {2, 1, 2};
        Integer[] disk2 = {3, 2, 3};
        Integer[] disk3 = {2, 2, 8};
        Integer[] disk4 = {2, 3, 4};
        Integer[] disk5 = {1, 3, 1};
        Integer[] disk6 = {4, 4, 5};

        disks.add(disk1);
        disks.add(disk2);
        disks.add(disk3);
        disks.add(disk4);
        disks.add(disk5);
        disks.add(disk6);

        diskStacking(disks);
    }

    // O(n^2) time | O(n) space
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Write your code here.
        Collections.sort(disks, Comparator.comparing(a -> a[2]));
        Integer[] heights = new Integer[disks.size()];
        Integer[] sequence = new Integer[disks.size()];

        int counter = 0;
        for (Integer[] disk : disks) {
            heights[counter] = disk[2];
            sequence[counter] = null;
            counter++;
        }

        int maxHeightIdx = disks.size() - 1;
        for (int i = 0; i < disks.size() - 1; i++) {
            Integer[] currentDisk = disks.get(i);
            for (int j = i + 1; j < disks.size(); j++) {
                Integer[] otherDisk = disks.get(j);
                if (checkSizes(currentDisk, otherDisk)) {
                    int calculatedHeight = heights[i] + otherDisk[2];
                    if (calculatedHeight > heights[j]) {
                        heights[j] = calculatedHeight;
                        sequence[j] = i;
                        maxHeightIdx = j;
                    }
                }
            }
        }

        List<Integer[]> result = buildSequence(disks, sequence, maxHeightIdx);

        Collections.reverse(result);

        return result;
    }

    private static List<Integer[]> buildSequence(List<Integer[]> disks, Integer[] sequence, Integer maxHeightIdx) {
        List<Integer[]> result = new ArrayList<>();
        Integer currentIdx = maxHeightIdx;
        while (currentIdx != null) {
            result.add(disks.get(currentIdx));
            currentIdx = sequence[currentIdx];
        }
        return result;
    }

    private static boolean checkSizes(Integer[] c, Integer[] o) {
        return c[0] < o[0] && c[1] < o[1] && c[2] < o[2];
    }


}
