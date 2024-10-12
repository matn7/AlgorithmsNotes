package october_2024;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/home/User/Documents/../Pictures";

        SimplifyPath simplifyPath = new SimplifyPath();
        String result = simplifyPath.simplifyPath(path);
        System.out.println(result);
    }

    // leetcode 71
    // O(n) time | O(n) space
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : split) {
            if (s.equals("") || s.equals(".")) {
                continue; // Ignore empty parts and current directory
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go up to the parent directory if possible
                }
            } else {
                stack.push(s); // Add the directory to the stack
            }
        }

        StringBuilder builder = new StringBuilder();

        // Build the simplified path
        while (!stack.isEmpty()) {
            builder.insert(0, "/" + stack.pop()); // Prepend to avoid reversing
        }

        // Handle the case for root directory
        return builder.length() == 0 ? "/" : builder.toString();
    }
}
