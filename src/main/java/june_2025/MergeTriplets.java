package june_2025;

public class MergeTriplets {

    public static void main(String[] args) {
        int[][] triplets = {{2,5,3}, {1,8,4}, {1,7,5}};
        int[] target = {2, 7, 5};

        MergeTriplets mergeTriplets = new MergeTriplets();
        boolean result = mergeTriplets.mergeTriplets(triplets, target);
        System.out.println(result);
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] res = new boolean[3];

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            res[0] = res[0] || triplet[0] >= target[0];
            res[1] = res[1] || triplet[1] >= target[1];
            res[2] = res[2] || triplet[2] >= target[2];
        }

        return res[0] && res[1] && res[2];
    }

}
