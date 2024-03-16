package january_2024;

import java.util.*;
import java.util.function.Predicate;

public class DetermineIfNumber {

    public static void main(String[] args) {
        boolean result = parseNumber("12.3");
        System.out.println(result);
        boolean result2 = parseNumber("12a");
        System.out.println(result2);
    }


    enum DigitState {
        BEGIN, NEGATIVE1, DIGIT1, DOT, DIGIT2, E, NEGATIVE2, DIGIT3
    }

    static Map<DigitState, List<DigitState>> PATHS = new HashMap<>();
    static Map<DigitState, Predicate<Character>> STATE_VALIDATOR = new HashMap<>();
    static  {
        PATHS.put(DigitState.BEGIN, Arrays.asList(DigitState.NEGATIVE1, DigitState.DIGIT1));
        PATHS.put(DigitState.NEGATIVE1, Arrays.asList(DigitState.DIGIT1, DigitState.DOT));
        PATHS.put(DigitState.DIGIT1, Arrays.asList(DigitState.DIGIT1, DigitState.DOT, DigitState.E));
        PATHS.put(DigitState.DOT, Arrays.asList(DigitState.DIGIT2));
        PATHS.put(DigitState.DIGIT2, Arrays.asList(DigitState.DIGIT2, DigitState.E));
        PATHS.put(DigitState.NEGATIVE2, Arrays.asList(DigitState.DIGIT3));
        PATHS.put(DigitState.DIGIT3, Arrays.asList(DigitState.DIGIT3));

        STATE_VALIDATOR.put(DigitState.BEGIN, a -> true);
        STATE_VALIDATOR.put(DigitState.DIGIT1, Character::isDigit);
        STATE_VALIDATOR.put(DigitState.NEGATIVE1, a -> a == '-');
        STATE_VALIDATOR.put(DigitState.DIGIT2, Character::isDigit);
        STATE_VALIDATOR.put(DigitState.DIGIT3, Character::isDigit);
        STATE_VALIDATOR.put(DigitState.NEGATIVE2, a -> a == '-');
        STATE_VALIDATOR.put(DigitState.DOT, a -> a == '.');
        STATE_VALIDATOR.put(DigitState.E, a -> a == 'e');
    }

    // O(n) time | O(k) -> O(1) space
    public static boolean parseNumber(String str) {
        DigitState state = DigitState.BEGIN;

        for (char c : str.toCharArray()) {
            boolean found = false;
            List<DigitState> nextStates = PATHS.get(state);
            for (DigitState nextState : nextStates) {
                if (STATE_VALIDATOR.get(nextState).test(c)) {
                    state = nextState;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        Set<DigitState> endStates = new HashSet<>();
        endStates.add(DigitState.DIGIT1);
        endStates.add(DigitState.DIGIT2);
        endStates.add(DigitState.DIGIT3);

        return endStates.contains(state);
    }

}
