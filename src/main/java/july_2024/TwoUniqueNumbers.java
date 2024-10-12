package july_2024;

import java.util.ArrayList;
import java.util.List;

public class TwoUniqueNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 1, 5, 7};

        List<Integer> integers = uniqueNo(arr);
        System.out.println(integers);
    }

    // O(n) time | O(1) space
    public static List<Integer> uniqueNo(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
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
        List<Integer> res = new ArrayList<>();
        res.add(setA);
        res.add(setB);
        return res;
    }

}
