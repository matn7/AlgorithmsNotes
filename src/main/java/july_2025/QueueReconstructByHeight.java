package july_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructByHeight {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        QueueReconstructByHeight queueReconstructByHeight = new QueueReconstructByHeight();
        int[][] result = queueReconstructByHeight.reconstructQueue(people);
        System.out.println(result);

    }

    // Intuition:
    // - sort
    // Approach:
    // - sort by p[0], if equal by p[1]
    // - add sorted by index
    // Complexity:
    // - O(nlog(n)) time | O(n) space
    // Code:

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (b[0] - a[0] == 0) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], new int[] {p[0], p[1]});
        }
        return result.toArray(new int[][] {});
    }

}
