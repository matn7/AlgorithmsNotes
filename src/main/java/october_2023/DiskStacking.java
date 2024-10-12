package october_2023;

import java.util.*;

public class DiskStacking {

    public static void main(String[] args) {
        int[][] disks = {{2,2,1}, {2,1,2}, {3,2,3}, {2,3,4}, {4,4,5}, {2,2,8}};
        // [width, depth, height]

        diskStacking(disks);

    }

    // O(n^2) time | O(n) space
    public static List<int[]> diskStacking(int[][] disks) {

        Arrays.sort(disks, Comparator.comparingInt(a -> a[2]));
        //                                         *
        // [[2,2,1], [2,1,2], [3,2,3], [2,3,4], [4,4,5], [2,2,8]]
        //                       *
        //
        // [     1,       2,       5,       4,       8,       8]
        //                                           j
        // [  null,    null,       1,    null,       2,    null]
        int[] heights = new int[disks.length];
        Integer[] sequence = new Integer[disks.length];
        int maxHeightIdx = 0;
        for (int i = 0; i < disks.length; i++) {
            int[] disk = disks[i];
            heights[i] = disk[2];
            sequence[i] = null;
        }

        for (int i = 0; i < disks.length; i++) {
            int[] current = disks[i];
            for (int j = i + 1; j < disks.length; j++) {
                int[] other = disks[j];
                if (canPlace(current, other)) {
                    if (heights[i] + other[2] > heights[j]) {  // (1 + 5) > 5
                        heights[j] = heights[i] + other[2];
                        sequence[j] = i;
                    }
                }
                if (heights[j] > heights[maxHeightIdx]) {
                    maxHeightIdx = j;
                }
            }
        }

        List<int[]> result = buildSequence(disks, sequence, maxHeightIdx);
        Collections.reverse(result);
        return result;
    }

    private static List<int[]> buildSequence(int[][] disks, Integer[] sequence, int startIdx) {
        List<int[]> result = new ArrayList<>();
        Integer idx = startIdx;
        while (idx != null) {
            int[] disk = disks[idx];
            result.add(disk);
            idx = sequence[idx];
        }
        return result;
    }

    private static boolean canPlace(int[] c, int[] o) {
        return c[0] < o[0] && c[1] < o[1] && c[2] < o[2];
    }

}
