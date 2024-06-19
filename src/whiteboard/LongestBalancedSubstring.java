package whiteboard;

import java.util.Stack;

public class LongestBalancedSubstring {

    public static void main(String[] args) {
        LongestBalancedSubstring lbs = new LongestBalancedSubstring();
        String string = ")(())()((()))";
        int result = lbs.longestBalancedSubstring(string);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int longestBalancedSubstring(String string) {
        // Write your code here.
        int maxLen = 0;
        Stack<Integer> idxStack = new Stack<>();
        idxStack.add(-1);
        for (int i = 0; i < string.length(); i++) {
            char curr = string.charAt(i);
            if (curr == '(') {
                idxStack.push(i);
            } else {
                idxStack.pop();
                if (idxStack.isEmpty()) {
                    idxStack.add(i);
                } else {
                    int length = i - idxStack.peek();
                    maxLen = Math.max(maxLen, length);
                }
            }
        }
        return maxLen;
    }


}
