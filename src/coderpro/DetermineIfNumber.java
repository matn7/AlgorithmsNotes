package coderpro;

import java.util.*;
import java.util.function.Function;

public class DetermineIfNumber {

    static Map<DigitState, List<DigitState>> PATHS = new HashMap<>();

    static Map<DigitState, Function<Character, Boolean>> STATE_VALIDATOR = new HashMap<>();

    static {
        PATHS.put(DigitState.BEGIN, Arrays.asList(DigitState.NEGATIVE1, DigitState.DIGIT1));
        PATHS.put(DigitState.NEGATIVE1, Arrays.asList(DigitState.DIGIT1, DigitState.DOT));
        PATHS.put(DigitState.DIGIT1, Arrays.asList(DigitState.DIGIT1, DigitState.DOT, DigitState.E));
        PATHS.put(DigitState.DOT, Arrays.asList(DigitState.DIGIT2));
        PATHS.put(DigitState.DIGIT2, Arrays.asList(DigitState.DIGIT2, DigitState.E));
        PATHS.put(DigitState.NEGATIVE2, Arrays.asList(DigitState.DIGIT3));
        PATHS.put(DigitState.DIGIT3, Arrays.asList(DigitState.DIGIT3));
        PATHS.put(DigitState.E, Arrays.asList(DigitState.DIGIT3, DigitState.NEGATIVE2));

        STATE_VALIDATOR.put(DigitState.BEGIN, a -> true);
        STATE_VALIDATOR.put(DigitState.DIGIT1, Character::isDigit);
        STATE_VALIDATOR.put(DigitState.NEGATIVE1, a -> a == '-');
        STATE_VALIDATOR.put(DigitState.DIGIT2, Character::isDigit);
        STATE_VALIDATOR.put(DigitState.DOT, a -> a == '.');
        STATE_VALIDATOR.put(DigitState.E, a -> a == 'e');
        STATE_VALIDATOR.put(DigitState.NEGATIVE2, a -> a == '-');
        STATE_VALIDATOR.put(DigitState.DIGIT3, Character::isDigit);

    }

    public static void main(String[] args) {

        DetermineIfNumber determineIfNumber = new DetermineIfNumber();
        boolean result = determineIfNumber.parse_number("123e5");
        System.out.println(result);
        System.out.println(determineIfNumber.parse_number("123a"));

    }

    // O(n) time | O(k) space (build finite state machine or O(1))
    public boolean parse_number(String str) {
        DigitState state = DigitState.BEGIN;

        for (char c : str.toCharArray()) {
            boolean found = false;
            List<DigitState> digitStates = PATHS.get(state);
            for (DigitState next_state : PATHS.get(state)) {
                Boolean apply = STATE_VALIDATOR.get(next_state).apply(c);
                if (apply) {
                    state = next_state;
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

enum DigitState {
    BEGIN(0),
    NEGATIVE1(1),
    DIGIT1(2),
    DOT(3),
    DIGIT2(4),
    E(5),
    NEGATIVE2(6),
    DIGIT3(7);

    private final int value;

    DigitState(int value) {
        this.value = value;
    }
}
