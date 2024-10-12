package october_2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ShortenPath {

    public static void main(String[] args) {
        String path = "/foo/../../../test/../test/../foo/bar/./baz";
        shortenPath(path);
    }

    // O(n) time | O(n) space
    public static String shortenPath(String path) {
        boolean isAbsolute = false;
        if (path.startsWith("/")) {
            isAbsolute = true;
        }
        String[] split = path.split("/");
        List<String> validElements = new ArrayList<>();
        for (String s : split) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            validElements.add(s);
        }
        Stack<String> stack = new Stack<>();
        if (isAbsolute) {
            stack.push("");
        }

        for (String element : validElements) {
            if (element.equals("..")) {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else if (stack.peek().equals("")) {
                    continue;
                } else if (stack.peek().equals("..")) {
                    stack.push("..");
                } else {
                    stack.pop();
                }
            } else {
                stack.push(element);
            }
        }

        List<String> elements = new ArrayList<>();
        while (!stack.isEmpty()) {
            elements.add(stack.pop());
        }
        Collections.reverse(elements);
        String join = String.join("/", elements);
        return join;
    }


}
