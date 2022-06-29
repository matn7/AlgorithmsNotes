package educative.bitwisexor;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 5, 2, 6, 4 };
        System.out.print("Missing number is: " + MissingNumber.findMissingNumber2(arr));
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;

        // find sum of all numbers from 1 to n
        int s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += i;
        }

        // subtract all numbers in input from sum
        for (int num : arr) {
            s1 -= num;
        }

        return s1;
    }

    public static int findMissingNumber2(int[] arr) {
        int n = arr.length + 1;
        // find sum of all numbers from 1 to n
        int x1 = 1;
        for (int i = 2; i <= n; i++) {
            x1 = x1 ^ i;
        }

        // x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n - 1; i++) {
            x2 = x2 ^ arr[i];
        }

        return x1 ^ x2;
    }

}
