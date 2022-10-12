package udemy.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumBracketsToRemove {

    public static void main(String[] args) {
//        String string = "a)bc(d)";
//        String string = "(ab(c)d";
//        String string = "))((";
        String string = "a)abc(d))))((abc";
        minimumBracketsToRemove(string);
    }

    // O(n) time | O(n) space
    public static String minimumBracketsToRemove(String string) {
        Stack<Element> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            if (current == '(') {
                stack.push(new Element(current, i));
            } else if (current == ')') {
                if (stack.isEmpty()) {
                    stack.push(new Element(current, i));
                } else {
                    Element topElement = stack.peek();
                    if (topElement.bracket == current) {
                        stack.push(new Element(current, i));
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        List<Character> newString = new ArrayList<>();
        for (char elem : string.toCharArray()) {
            newString.add(elem);
        }

        while (!stack.isEmpty()) {
            newString.remove(stack.pop().idx);
        }

        StringBuilder result = new StringBuilder();
        for (char elem : newString) {
            result.append(elem);
        }

        return result.toString();
    }

    static class Element {
        char bracket;
        int idx;

        public Element(char bracket, int idx) {
            this.bracket = bracket;
            this.idx = idx;
        }
    }

}
