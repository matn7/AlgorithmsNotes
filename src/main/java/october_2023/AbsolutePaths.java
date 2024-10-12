package october_2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AbsolutePaths {

    public static void main(String[] args) {
        String path = "/../../../users/tech/docs/.././desk/..";

        // .. up one dir
        // . curr dir
        // / absolute
        // .. relative
        String s = absolutePaths(path);
        System.out.println(s);
    }

    public static String absolutePaths(String path) {
        String[] split = path.split("/");
        // ["..", "..", "..", "users", "tech", "docs", "..", "." , "docs", ".."]
        List<String> filteredPath = new ArrayList<>();
        for (String s : split) {
            if (s.equals(".") || s.equals("")) {
                continue;
            }
            filteredPath.add(s);
        }

        Stack<String> stack = new Stack<>();
        for (String s : filteredPath) {
            if (s.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                if (stack.peek().equals("..")) {
                    stack.push(s);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        List<String> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        Collections.reverse(res);

        return String.join("/", res);
    }

}
