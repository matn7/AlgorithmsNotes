package january_2025;

import java.util.HashSet;
import java.util.Set;

public class MergeTriplets {

    public static void main(String[] args) {
        int[][] triplets = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target = {2, 7, 5};

        MergeTriplets mergeTriplets = new MergeTriplets();
        boolean result = mergeTriplets.mergeTriplets(triplets, target);
        System.out.println(result);
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {

        Set<Integer> result = new HashSet<>();

        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    result.add(i);
                }
            }
        }
        return result.size() == 3;
    }

}
