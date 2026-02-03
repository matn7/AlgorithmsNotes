package january_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        queueReconstructionByHeight.reconstructQueue(people);
    }

    // O(nlog(n)) time | O(n) space
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> {
            if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            result.add(person[1], person);
        }

        return result.toArray(new int[result.size()][]);
    }

}
