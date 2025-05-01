package april_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        QueueReconstructionByHeight queue = new QueueReconstructionByHeight();
        int[][] result = queue.reconstructQueue(people);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (b[0] - a[0] == 0) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> resArr = new ArrayList<>();

        for (int[] person : people) {
            resArr.add(person[1], person);
        }

        return resArr.toArray(new int[people.length][2]);
    }

}
