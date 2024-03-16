package november_2023;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 2, 3, 4};

        System.out.println(singleNumber(arr));
    }

    // O(n) time | O(1) space
    public static int singleNumber(int[] arr) {
        int num = 0;

        for (int n : arr) {
            num ^= n;
        }

        return num;
    }

}
