package april_2025;

import java.util.*;
import java.util.function.Predicate;

public class DetermineIfNumber2 {

    public static void main(String[] args) {
        DetermineIfNumber2 determineIfNumber = new DetermineIfNumber2();
        System.out.println(determineIfNumber.isNumber("123"));
        System.out.println(determineIfNumber.isNumber("12.3"));
        System.out.println(determineIfNumber.isNumber("-123"));
        System.out.println(determineIfNumber.isNumber("-.3"));
        System.out.println(determineIfNumber.isNumber("1.5e5"));
        System.out.println(determineIfNumber.isNumber("12a"));
    }

    static Map<State, Predicate<Character>> STATE = new HashMap<>();
    static Map<State, List<State>> NEXT_STATE = new HashMap<>();

    static {
        STATE.put(State.BEGIN, a -> true);
        STATE.put(State.NEGATIVE, a -> a == '-');
        STATE.put(State.NUM1, Character::isDigit);
        STATE.put(State.DOT, a -> a == '.');
        STATE.put(State.NUM2, Character::isDigit);
        STATE.put(State.NUM3, Character::isDigit);
        STATE.put(State.NEGATIVE2, a -> a == '-');
        STATE.put(State.E, a -> a == 'e');
        STATE.put(State.DOT2, a -> a == '.');

        NEXT_STATE.put(State.BEGIN, Arrays.asList(State.NEGATIVE, State.NUM1, State.DOT2));
        NEXT_STATE.put(State.NEGATIVE, Arrays.asList(State.NUM1, State.DOT));
        NEXT_STATE.put(State.NUM1, Arrays.asList(State.NUM1, State.DOT, State.E));
        NEXT_STATE.put(State.DOT, Arrays.asList(State.NUM2));
        NEXT_STATE.put(State.DOT2, Arrays.asList(State.NUM1));
        NEXT_STATE.put(State.E, Arrays.asList(State.NUM3, State.NEGATIVE2));
        NEXT_STATE.put(State.NUM2, Arrays.asList(State.NUM2, State.E));
        NEXT_STATE.put(State.NUM3, Arrays.asList(State.NUM3));
        NEXT_STATE.put(State.NEGATIVE2, Arrays.asList(State.NUM3));

    }

    enum State {
        BEGIN, NEGATIVE, NUM1, DOT, DOT2, E, NUM2, NUM3, NEGATIVE2
    }

    public boolean isNumber(String s) {
        State currState = State.BEGIN;
        boolean isValidState;

        for (char c : s.toCharArray()) { // 123
            isValidState = false;
            List<State> nextStates = NEXT_STATE.get(currState); // [NEG1, NUM1]

            for (State state : nextStates) {
                if (STATE.get(state).test(c)) {
                    isValidState = true;
                    currState = state;
                    break;
                }
            }
            if (!isValidState) {
                return false;
            }
        }


        Set<State> validEnd = new HashSet<>();
        validEnd.add(State.NUM1);
        validEnd.add(State.NUM2);
        validEnd.add(State.NUM3);

        return validEnd.contains(currState);
    }

}

















