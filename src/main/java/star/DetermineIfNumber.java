package star;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DetermineIfNumber {

    static Map<Operations, Map<Operations, Function<Character, Boolean>>> maps = new HashMap<>();
    static Map<Operations, Function<Character, Boolean>> validOperations = new HashMap<>();

    static {
        validOperations.put(Operations.NUMBER, Character::isDigit);
        validOperations.put(Operations.E, a -> a.equals('e'));
        validOperations.put(Operations.MINUS, a -> a.equals('-'));

//        Set<Function<Character, Boolean>> start = new HashSet<>();
        Map<Operations, Function<Character, Boolean>> start = new HashMap<>();
        start.put(Operations.MINUS, validOperations.get(Operations.MINUS));
        start.put(Operations.NUMBER, validOperations.get(Operations.NUMBER));

//        Set<Function<Character, Boolean>> number = new HashSet<>();
        Map<Operations, Function<Character, Boolean>> number = new HashMap<>();
        number.put(Operations.NUMBER, validOperations.get(Operations.NUMBER));
        number.put(Operations.E, validOperations.get(Operations.E));

//        Set<Function<Character, Boolean>> minus = new HashSet<>();
        Map<Operations, Function<Character, Boolean>> minus = new HashMap<>();
        minus.put(Operations.NUMBER, validOperations.get(Operations.NUMBER));

//        Set<Function<Character, Boolean>> e = new HashSet<>();
        Map<Operations, Function<Character, Boolean>> e = new HashMap<>();
        e.put(Operations.NUMBER, validOperations.get(Operations.NUMBER));
        e.put(Operations.MINUS, validOperations.get(Operations.MINUS));

//        Set<Function<Character, Boolean>> end = new HashSet<>();
        Map<Operations, Function<Character, Boolean>> end = new HashMap<>();
        e.put(Operations.END, validOperations.get(Operations.NUMBER));

        maps.put(Operations.START, start);
        maps.put(Operations.NUMBER, number);
        maps.put(Operations.MINUS, minus);
        maps.put(Operations.E, e);
        maps.put(Operations.END, end);
    }

    public static void main(String[] args) {
//        String number = "123e5";
        String number = "123ea";

        DetermineIfNumber determineIfNumber = new DetermineIfNumber();
        boolean result = determineIfNumber.isNumber(number);
        System.out.println(result);
    }

    // O(n) time | O(k) space (build finite state machine or O(1))
    public boolean isNumber(String number) {

        Operations currentOperation = Operations.START;
        Map<Operations, Function<Character, Boolean>> allowedElement = maps.get(currentOperation);

        char current = '*';
        for (int i = 0; i < number.length(); i++) {
            current = number.charAt(i); // 1

            boolean valid = false;

            for (Map.Entry<Operations, Function<Character, Boolean>> elem : allowedElement.entrySet()) {
                Function<Character, Boolean> fn = elem.getValue();
                Operations key = elem.getKey();
                if (fn.apply(current)) {
                    valid = true;
                    currentOperation = key;
                    allowedElement = maps.get(currentOperation);
                    break;
                }
            }

            if (!valid) {
                return false;
            }

        }
        Function<Character, Boolean> fn = validOperations.get(Operations.NUMBER);
        return fn.apply(current);
    }

    enum Operations {
        START,
        NUMBER,
        MINUS,
        E,
        END
    }

}


