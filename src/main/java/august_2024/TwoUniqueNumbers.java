package august_2024;

import java.util.List;
import java.util.function.IntUnaryOperator;

public class TwoUniqueNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 1, 5, 7};

        twoUniqueNumbers(arr);
    }

    // O(n) time | O(1) space
    public static int[] twoUniqueNumbers(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }

        // 0011
        int pos = 0;
        int temp = result;
        while ((temp & 1) == 0) {
            pos++;
            temp = temp >> 1;
        }

        int setA = 0;
        int setB = 0;
        int mask = (1 << pos);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & mask) > 0) {
                setA = setA ^ arr[i];
            } else {
                setB = setB ^ arr[i];
            }
        }
        return new int[] {setA, setB};
    }

}
