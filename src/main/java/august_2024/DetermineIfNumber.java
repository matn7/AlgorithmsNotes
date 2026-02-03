package august_2024;

import java.util.*;
import java.util.function.Predicate;

public class DetermineIfNumber {

    public static void main(String[] args) {
        String str = "123a-5";

        DetermineIfNumber determineIfNumber = new DetermineIfNumber();

        boolean result = determineIfNumber.isNumber(str);
        System.out.println(result);
    }

    static Map<State, Predicate<Character>> states = new HashMap<>();
    static Map<State, List<State>> nextStates = new HashMap<>();

    static {
        states.put(State.BEGIN, a -> true);
        states.put(State.NUM1, Character::isDigit);
        states.put(State.NUM2, a -> Character.isDigit(a));
        states.put(State.NUM3, Character::isDigit);
        states.put(State.DOT, a -> a == '.');
        states.put(State.E, a -> a == 'e' || a == 'E');
        states.put(State.NEGATIVE1, a -> a == '-' || a == '+');
        states.put(State.NEGATIVE2, a -> a == '-' || a == '+');

        nextStates.put(State.BEGIN, Arrays.asList(State.NEGATIVE1, State.NUM1, State.DOT));
        nextStates.put(State.NEGATIVE1, Arrays.asList(State.NUM1, State.DOT));
        nextStates.put(State.NUM1, Arrays.asList(State.NUM1, State.DOT, State.E));
        nextStates.put(State.DOT, Arrays.asList(State.NUM2, State.E));
        nextStates.put(State.NUM2, Arrays.asList(State.NUM2, State.E));
        nextStates.put(State.E, Arrays.asList(State.NEGATIVE2, State.NUM3));
        nextStates.put(State.NEGATIVE2, Arrays.asList(State.NUM3));
        nextStates.put(State.NUM3, Arrays.asList(State.NUM3));
    }

    public boolean isNumber(String str) {
        State state = State.BEGIN;
        boolean seenDigit = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            List<State> next = nextStates.get(state);
            boolean valid = false;

            for (State n : next) {
                if (states.get(n).test(c)) {
                    if ((n == State.E) && !seenDigit) {
                        return false;
                    }

                    if (Character.isDigit(c)) {
                        seenDigit = true;
                    }
                    state = n;
                    valid = true;
                    break;
                }
            }

            if (!valid) return false;
        }

        return seenDigit && (
                state == State.NUM1 ||
                        state == State.NUM2 ||
                        state == State.NUM3 ||
                        state == State.DOT
        );
    }

    enum State {
        BEGIN, NUM1, NUM2, NUM3, DOT, E, NEGATIVE1, NEGATIVE2
    }

}
