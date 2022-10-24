package whiteboard;

import java.util.List;

public class ValidateSequenceRand {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        if (sequence.size() > array.size()) {
            return false;
        }
        if (sequence.size() == 0) {
            return true;
        }
        int i = 0;
        int j = 0;

        while (i < array.size() - 1 && j < sequence.size() - 1) {
            if (array.get(i) == sequence.get(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == sequence.size();
    }
}
