package problems.easy;

import java.util.Arrays;
import java.util.List;

public class ValidateSequence {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);

        isValidSubsequence(array, sequence);
    }

    // O(n) time | O(1) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int arrIdx = 0;
        int seqIdx = 0;

        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx) == sequence.get(seqIdx)) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }
}
