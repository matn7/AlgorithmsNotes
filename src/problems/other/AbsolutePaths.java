package problems.other;


import java.util.Stack;

public class AbsolutePaths {

    public static void main(String[] args) {
        String path = "/../../../users/tech/docs/.././desk/../";
        AbsolutePaths absolutePaths = new AbsolutePaths();
        absolutePaths.cleanPath(path);
    }

    // O(n) time | O(n) space
    public String cleanPath(String path) {
        String[] folders = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String folder : folders) {
            if (folder.equals(".")) {
                continue;
            }
            if (folder.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else {
                stack.push(folder);
            }
        }
        String result = String.join("/", stack);
        return result;
    }

}
