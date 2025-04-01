package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        ReconstructQueue reconstructQueue = new ReconstructQueue();
        int[][] result = reconstructQueue.reconstructQueue(people);
        System.out.println(result);
    }

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }

        return res.toArray(new int[res.size()][2]);
    }

}
