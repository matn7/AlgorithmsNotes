package october_2023;

public class KadenesAlgorithm {

    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

        System.out.println(kadenesAlgorithm(arr));

    }

    // O(n) time | O(1) space
    public static int kadenesAlgorithm(int[] arr) {
        int maxNumberHere = 0;
        int maxSoFar = 0;
        for (int num : arr) {
            maxNumberHere = Math.max(maxNumberHere + num, num);
            maxSoFar = Math.max(maxSoFar, maxNumberHere);
        }
        return maxSoFar;
    }

}
