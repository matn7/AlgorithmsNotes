package october_2023;

import java.rmi.MarshalledObject;
import java.util.*;
import java.util.function.Predicate;

public class DetermineIfNumber {

    public static void main(String[] args) {
        String str = "123e-5";
        String[] tests = {"123", "12.3", "-12.3", "-.3", "1.5e5", "12a", str};
        for (String test : tests) {
            System.out.println(parseNumber(test));
        }

    }

    // O(n) time | O(k) space (build state machine)
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
        Set<State> endStates = new HashSet<>();
        endStates.add(State.NUM1);
        endStates.add(State.NUM2);
        endStates.add(State.NUM3);

        return endStates.contains(currState);
    }

    static Map<State, Predicate<Character>> stateValidator = new HashMap<>();
    static Map<State, List<State>> nextStates = new HashMap<>();

    static {
        stateValidator.put(State.BEGIN, a -> true);
        stateValidator.put(State.NUM1, Character::isDigit);
        stateValidator.put(State.NUM2, Character::isDigit);
        stateValidator.put(State.NUM3, Character::isDigit);
        stateValidator.put(State.DOT, a -> a == '.');
        stateValidator.put(State.E, a -> a == 'e');
        stateValidator.put(State.NEGATIVE, a -> a == '-');
        stateValidator.put(State.NEGATIVE2, a -> a == '-');

        nextStates.put(State.BEGIN, Arrays.asList(State.NEGATIVE, State.NUM1));
        nextStates.put(State.NEGATIVE, Arrays.asList(State.NUM1, State.DOT));
        nextStates.put(State.NUM1, Arrays.asList(State.NUM1, State.E, State.DOT));
        nextStates.put(State.DOT, Arrays.asList(State.NUM2));
        nextStates.put(State.NUM2, Arrays.asList(State.E, State.NUM2));
        nextStates.put(State.NEGATIVE2, Arrays.asList(State.NUM3));
        nextStates.put(State.NUM3, Arrays.asList(State.NUM3));
        nextStates.put(State.E, Arrays.asList(State.NUM3, State.NEGATIVE2));

    }

    enum State {
        BEGIN, NUM1, NUM2, NUM3, DOT, E, NEGATIVE, NEGATIVE2
    }

}
