package april_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AbsolutePath {

    public static void main(String[] args) {
        String path = "/users///tech/docs/.././desk/..//";

        AbsolutePath absolutePath = new AbsolutePath();
        String result = absolutePath.absolutePath(path);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public String absolutePath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : split) {
            if (str.isEmpty() || str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                // pop element
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(str);
            }
        }
        Stack<String> stackRev = new Stack<>();
        while (!stack.isEmpty()) {
            stackRev.add(stack.pop());
        }
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        while (!stackRev.isEmpty()) {
            builder.append(stackRev.pop());
            builder.append("/");
        }
        return builder.toString();
    }


}
