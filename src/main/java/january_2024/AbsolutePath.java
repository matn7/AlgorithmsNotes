package january_2024;

import java.util.Stack;

public class AbsolutePath {

    public static void main(String[] args) {
        String path = "/users/tech/docs/.././desk/../";

        String result = absolutePath(path);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String absolutePath(String path) {
        String[] folders = path.split("/");

        // [ users, tech, docs, .., deck, .., users, tech]
        Stack<String> stack = new Stack<>();

        // users, tech, users tech

        for (String folder : folders) {
            if (folder.equals(".")) {
                continue;
            } else if (folder.equals("..")) {
                stack.pop();
            } else {
                stack.push(folder);
            }
        }
        return String.join("/", stack);
    }

}
