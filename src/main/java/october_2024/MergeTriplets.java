package october_2024;

import java.util.HashSet;
import java.util.Set;

public class MergeTriplets {

    public static void main(String[] args) {
        int[][] triplets = {
                {2, 5, 3},
                {1, 8, 4},
                {1, 7, 5}
        };

        int[] target = {2, 7, 5};
    }

    // O(n) time | O(3) space
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            for (int i = 0; i < t.length; i++) {
                int v = t[i];
                if (v == target[i]) {
                    good.add(i);
                }
            }
        }
        return good.size() == 3;
    }

}
