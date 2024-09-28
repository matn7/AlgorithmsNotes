package july_2024;

import java.util.*;
import java.util.function.Predicate;

public class DetermineIfNumber {


    public static void main(String[] args) {
        String number = "123e-5";

        boolean result = parseNumber(number);
        System.out.println(result);
    }

    // LAMBDA - FLASHCARD

    // O(n) time | O(k) space
    public static boolean parseNumber(String str) {
        State currState = State.BEGIN;
        for (char c : str.toCharArray()) {
            boolean validPart = false;
            List<State> states = nextStates.get(currState);
            for (State state : states) {
                Predicate<Character> fn = stateValidator.get(state);
                if (fn.test(c)) {
                    validPart = true;
                    currState = state;
                    break;
                }
            }
            if (!validPart) {
                return false;
            }
        }
        Set<State> end = Set.of(State.NUM1, State.NUM2, State.NUM3);
        return end.contains(currState);
    }

    static Map<State, Predicate<Character>> stateValidator = new HashMap<>();
    static Map<State, List<State>> nextStates = new HashMap<>();

    static {
        stateValidator.put(State.BEGIN, a -> true);
        stateValidator.put(State.NUM1, a -> Character.isDigit(a));
        stateValidator.put(State.NUM2, a -> Character.isDigit(a));
        stateValidator.put(State.NUM3, Character::isDigit);
        stateValidator.put(State.DOT, a -> a == '.');
        stateValidator.put(State.E, a -> a == 'e');
        stateValidator.put(State.NEGATIVE1, a -> a == '-');
        stateValidator.put(State.NEGATIVE2, a -> a == '-');

        nextStates.put(State.BEGIN, Arrays.asList(State.NEGATIVE1, State.NUM1));
        nextStates.put(State.NEGATIVE1, Arrays.asList(State.NUM1, State.DOT));
        nextStates.put(State.NUM1, Arrays.asList(State.NUM1, State.E, State.DOT));
        nextStates.put(State.DOT, Arrays.asList(State.NUM2));
        nextStates.put(State.NEGATIVE2, Arrays.asList(State.NUM3));
        nextStates.put(State.NUM3, Arrays.asList(State.NUM3));
        nextStates.put(State.E, Arrays.asList(State.NUM3, State.NEGATIVE2));
    }

    enum State {
        BEGIN, NUM1, NUM2, NUM3, DOT, E, NEGATIVE1, NEGATIVE2;
    }

}
