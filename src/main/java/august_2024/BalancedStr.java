package august_2024;

import java.util.*;

public class BalancedStr {

    public static void main(String[] args) {
        System.out.println(isBalanced("[{()}]"));
        System.out.println(isBalanced("[({(})]"));
        System.out.println(isBalanced("{[}"));
        System.out.println(isBalanced("({}{}([{}]))"));
        System.out.println(isBalanced("({"));
    }

    public static boolean isBalanced(String str) {
        Stack<Character> openingStack = new Stack<>();
        // [{( )}]
        //   * *
        Map<Character, Character> parensMap = new HashMap<>();
        parensMap.put(']', '[');
        parensMap.put('}', '{');
        parensMap.put(')', '(');
        Collection<Character> opening = parensMap.values();

        for (char c : str.toCharArray()) {
            if (opening.contains(c)) {
                openingStack.push(c);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                }
                Character pop = openingStack.pop(); // (
                Character curr = parensMap.get(c); // map { ')' : '('} // (
                if (pop != curr) {
                    return false;
                }
            }
        }
        
        return openingStack.isEmpty();
    }

}
