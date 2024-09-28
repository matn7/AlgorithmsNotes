package august_2024;

import java.net.BindException;
import java.util.*;
import java.util.function.Predicate;

public class DetermineIfNumber {

    public static void main(String[] args) {
        String str = "123a-5";

        boolean result = checkNumber(str);
        System.out.println(result);
    }

    static Map<State, Predicate<Character>> states = new HashMap<>();
    static Map<State, List<State>> nextStates = new HashMap<>();

    static {
        states.put(State.BEGIN, a -> true);
        states.put(State.NUM1, a -> Character.isDigit(a));
        states.put(State.NUM2, a -> Character.isDigit(a));
        states.put(State.NUM3, a -> Character.isDigit(a));
        states.put(State.DOT, a -> a == '.');
        states.put(State.E, a -> a == 'e');
        states.put(State.NEGATIVE1, a -> a == '-');
        states.put(State.NEGATIVE2, a -> a == '-');
        
        nextStates.put(State.BEGIN, Arrays.asList(State.NEGATIVE1, State.NUM1));
        nextStates.put(State.NEGATIVE1, Arrays.asList(State.NUM1, State.DOT));
        nextStates.put(State.NUM1, Arrays.asList(State.NUM1, State.DOT, State.E));
        nextStates.put(State.DOT, Arrays.asList(State.NUM2));
        nextStates.put(State.NUM2, Arrays.asList(State.NUM2, State.E));
        nextStates.put(State.NEGATIVE2, Arrays.asList(State.NUM3));
        nextStates.put(State.NUM3, Arrays.asList(State.NUM3));
        nextStates.put(State.E, Arrays.asList(State.NUM3, State.NEGATIVE2));
    }


    public static boolean checkNumber(String str) {
        State state = State.BEGIN;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); // '1'
            List<State> nextStates = DetermineIfNumber.nextStates.get(state); // ['NEGATIVE1', 'NUM1']
            boolean validPart = false;

            for (State next : nextStates) {
                Predicate<Character> fn = states.get(next);
                if (fn.test(c)) {
                    validPart = true;
                    state = next;
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

        return endStates.contains(state);
    }

    enum State {
        BEGIN, NUM1, NUM2, NUM3, DOT, E, NEGATIVE1, NEGATIVE2
    }

}
