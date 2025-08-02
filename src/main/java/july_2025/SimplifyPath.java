package july_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/home/user/Documents////../Pictures";

        SimplifyPath simplifyPath = new SimplifyPath();
        String result = simplifyPath.simplifyPath(path);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        // . -> curr (not add)
        // .. -> back one up (remove from path)
        List<String> parts = new ArrayList<>();
        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            parts.add(s);
        }
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(part);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            String curr = stack.pop();
            builder.insert(0, curr);
            builder.insert(0, "/");
        }
        return builder.toString();
    }

}
