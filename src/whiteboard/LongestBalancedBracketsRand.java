package whiteboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestBalancedBracketsRand {


    public static void main(String[] args) {
//        String string = "(()))()(((()())))";
//        String string = "())*()(()())*";
        String string = "))())(())((())(())((";
        LongestBalancedBracketsRand longestBalancedBracketsRand = new LongestBalancedBracketsRand();
        longestBalancedBracketsRand.longestBalancedSubstring(string);
    }

    public int longestBalancedSubstring(String string) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        int maxBalanced = 0;
        int currMax = 0;
        List<Integer> listOfBalanced = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                if (stack.isEmpty()) {
                    currMax = 0;
                    continue;
                }
                currMax += 2;
                maxBalanced = Math.max(maxBalanced, currMax);
                stack.pop();
            }
        }

        return maxBalanced;
    }

}
