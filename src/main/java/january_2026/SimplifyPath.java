package january_2026;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
//        String path = "/.../a/../b/c/../d/./";
        String path = "/home/user/Documents/../Pictures";

        SimplifyPath simplifyPath = new SimplifyPath();
        String result = simplifyPath.simplifyPath(path);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        List<String> filtered = new ArrayList<>();

        for (String str : split) {
            if (str.equals(".")) {
                continue;
            }
            if (str.equals("")) {
                continue;
            }
            filtered.add(str);
        }
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String str : filtered) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(str);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        while (!stack.isEmpty()) {
            builder.append(stack.removeFirst());
            if (!stack.isEmpty()) {
                builder.append("/");
            }
        }
        return builder.toString();

    }

}
