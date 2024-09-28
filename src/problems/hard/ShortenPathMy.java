package problems.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortenPathMy {

    public static void main(String[] args) {
        String path = "foo/../../../test/../test/../foo//bar/./baz"; // relative path ../../foo/bar/baz
//        String path = "/foo/../../../test/../test/../foo//bar/./baz"; // absolute path /foo/bar/baz

        String result = shortenPath(path);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    // OK - repeated 27/01/2022
    public static String shortenPath(String path) {
        // Write your code here;
        // path = "/foo/../../../test/../test/../foo//bar/./baz"
        boolean startsWithSlash = path.charAt(0) == '/'; // true
        String[] tokensSplit = path.split("/");
        // ["", "foo", "..", "..", "..", "test", "..", "test", "..", "foo", "", "bar", ".", "baz"]
        List<String> tokens = new ArrayList<>();
        for (String element : tokensSplit) {
            if (element.length() > 0 && !element.equals(".")) {
                tokens.add(element);
            }
        }
        // ["foo", "..", "..", "..", "test", "..", "test", "..", "foo", "bar", "baz"]
        Stack<String> stack = new Stack<>();
        if (startsWithSlash) {
            stack.add("");
        }
        // stack = ["", "foo", "bar", "baz"]
        for (String token : tokens) {
            if (token.equals("..")) {
                // empty or .. already on stack
                // ../../foo
                if (stack.size() == 0 || stack.peek().equals("..")) { // only needed if relative path
                    stack.add(token);
                } else if (!stack.peek().equals("")) { // do not pop when only one "" element
                    // /
                    // directory
                    stack.pop();
                }
            } else {
                stack.add(token);
            }
        }
        if (stack.size() == 1 && stack.get(0).equals("")) {
            return "/";
        }
//        StringBuilder builder = new StringBuilder();
//        for (String element : stack) {
//            if (element.equals("")) {
//                builder.append("/");
//            } else {
//                builder.append(element);
//                builder.append("/");
//            }
//        }

        String result = String.join("/", stack);

//        String result = builder.toString().substring(0, builder.length() - 1);
        return result; // /foo/bar/baz
    }

}
