package whiteboard;

import java.util.List;

public class ValidateSequence {

    // O(n) time | O(1) space
    // #2: 09/07/2022
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int j = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == sequence.get(j)) {
                j++;
                if (j == sequence.size()) {
                    return true;
                }
            }
        }
        return false;
    }

}
