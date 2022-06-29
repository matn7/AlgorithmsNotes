package educative.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateExpressionMemoize {

    public static void main(String[] args) {
        EvaluateExpression ee = new EvaluateExpression();
        List<Integer> result = ee.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        ee = new EvaluateExpression();
        result = ee.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }

    Map<String, List<Integer>> map = new HashMap<>();

    // O(n*2^n) time | O(2^n) space
    public List<Integer> diffWaysToEvaluateExpression(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> result = new ArrayList<>();

        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char chr = input.charAt(i);
                if (!Character.isDigit(chr)) {
                    List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
                    for (int part1 : leftParts) {
                        for (int part2 : rightParts) {
                            if (chr == '+') {
                                result.add(part1 + part2);
                            } else if (chr == '-') {
                                result.add(part1 - part2);
                            } else if (chr == '*') {
                                result.add(part1 * part2);
                            }
                        }
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }

}