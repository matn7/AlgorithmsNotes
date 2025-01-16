package december_2024;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis2 {

    public static void main(String[] args) {
        String s = "((**)";
        ValidParenthesis2 validParenthesis = new ValidParenthesis2();
        boolean result = validParenthesis.checkValidString(s);
        System.out.println(result);
    }

    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin = leftMin + 1;
                leftMax = leftMax + 1;
            } else if (c == ')') {
                leftMin = leftMin - 1;
                leftMax = leftMax - 1;
            } else {
                leftMin = leftMin - 1;
                leftMax = leftMax + 1;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) { // s = (*)(
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }



}
