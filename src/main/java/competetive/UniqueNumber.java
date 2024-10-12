package competetive;

public class UniqueNumber {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 6, 6, 4, 5, 1, 9};

        System.out.println(uniqueNumber(arr));
    }

    // O(n) time | O(1) space
    public static int uniqueNumber(int[] arr) {
        int res = 0;

        for (int num : arr) {
            res = res ^ num;
        }

        return res;
    }


}
