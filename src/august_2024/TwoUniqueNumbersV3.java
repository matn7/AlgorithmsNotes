package august_2024;

public class TwoUniqueNumbersV3 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 1, 5, 7};

        twoUniqueNumbers(arr);
    }

    // O(n) time | O(1) space
    public static int[] twoUniqueNumbers(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum ^= a;
        }

        // 4 - 100
        // 7 - 111
        // 3 - 011 <= sum
        int temp = sum;
        int pos = 0;
        while ((temp & 1) == 0) {
            pos++;
            temp = temp >> 1;
        }

        int setA = 0;
        int setB = 0;
        int mask = 1 << pos;
        for (int num : arr) {
            if ((num & mask) == 1) {
                setB = num;
            } else {
                setA = num;
            }
        }

        return new int[] {setA, setB};
    }

}
