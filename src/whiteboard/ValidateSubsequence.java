package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class ValidateSubsequence {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        int[] arr = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] seq = {1, 6, -1, 11};
        for (int a : arr) {
            array.add(a);
        }
        for (int s : seq) {
            sequence.add(s);
        }

        boolean result = isValidSubsequence(array, sequence);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        if (sequence.size() > array.size()) {
            return false;
        }
        int sIdx = 0;
        for (int i = 0; i < array.size(); i++) {
            if (sIdx < sequence.size() && array.get(i) == sequence.get(sIdx)) {
                sIdx++;
            }
        }
        return sIdx == sequence.size();
    }

}


