package udemy.faang.datastructuresalgorithms;

import java.util.HashMap;
import java.util.Map;

public class RecurringCharacters {

    public static void main(String[] args) {
        // int[] input = {2, 5, 1, 2, 3, 5, 1, 2, 4};
         int[] input = {2, 1, 1, 2, 3, 5, 1, 2, 4};
//        int[] input = {2, 3, 4, 5};

        RecurringCharacters recurringCharacters = new RecurringCharacters();
        Integer result = recurringCharacters.firstRecurringCharacter(input);
        System.out.println();
    }

    // O(n) time | O(n) space
    public Integer firstRecurringCharacter(int[] input) {
        if (input.length == 0) {
            return null;
        }
        Map<Integer, Boolean> seen = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (seen.containsKey(input[i])) {
                return input[i];
            } else {
                seen.put(input[i], Boolean.TRUE);
            }
        }
        return null;
    }

}
