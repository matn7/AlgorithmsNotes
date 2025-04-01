package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue2 {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 2}, {5, 0}, {6, 1}};

        ReconstructQueue2 reconstructQueue2 = new ReconstructQueue2();
        int[][] result = reconstructQueue2.reconstructQueue(people);
        System.out.println(result);

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }
        int[][] res = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

}
