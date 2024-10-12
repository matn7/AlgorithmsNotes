package november_2023;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> array = new ArrayList<>();
        for (int num : arr) {
            array.add(num);
        }

        powerSet(array);
    }

    // O(n*2^n) time | O(n*2^n) space
    public static List<List<Integer>> powerSet(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (Integer num : array) {
            int len = result.size();
            for (int i = 0; i < len; i++) {
                List<Integer> integers = new ArrayList<>(result.get(i));
                integers.add(num);
                result.add(integers);
            }
        }
        return result;
    }


}
