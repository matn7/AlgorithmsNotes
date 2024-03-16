package competetive;

import java.util.ArrayList;
import java.util.List;

public class TwoUniqueNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 3, 1, 5, 7};

        uniqueNo2(arr);

    }

    // O(n) time | O(1) space
    public static List<Integer> uniqueNo2(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }

        // Position
        int pos = 0;
        int temp = result;
        while ((temp & 1) == 0) {
            pos++;
            temp = temp >> 1;
        }

        // Filter out the numbers from the array which have set bit at 'pos'
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
        List<Integer> resultArr = new ArrayList<>();
        resultArr.add(setA);
        resultArr.add(setB);

        return resultArr;
    }

}
