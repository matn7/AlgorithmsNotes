package problems.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortenPath {

    public static void main(String[] args) {
        String path = "/foo/../test/../test/../foo//bar/./baz";

        shortenPath(path);

    }

    // O(n) time | O(n) space
    public static String shortenPath(String path) {
        // Write your code here;
        boolean startsWithSlash = false;
        if (path.charAt(0) == '/') {
            startsWithSlash = true;
        }

        String[] split = path.split("/");
        List<String> tokens = new ArrayList<>();
        for (String element : split) {
            if (element.length() > 0 && !element.equals(".")) {
                tokens.add(element);
            }
        }

        Stack<String> stack = new Stack<>();
        if (startsWithSlash) {
            stack.push("");
        }
        for (String token : tokens) {
            if (token.equals("..")) {
                if (stack.isEmpty() || stack.peek().equals("..")) {
                    stack.push(token);
                } else if (stack.peek().equals("")) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        if (stack.size() == 1 && stack.peek().equals("/")) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for (String element : stack) {
            if (element.equals("")) {
                builder.append("/");
            } else {
                builder.append(element);
                builder.append("/");
            }
        }

        String result = builder.toString().substring(0, builder.length() - 1);
        return result;
    }

}
