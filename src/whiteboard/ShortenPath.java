package whiteboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortenPath {

    public static void main(String[] args) {
        String path = "/../../../foo/../test/../test/../foo//bar/./baz";

        shortenPath(path);
    }

    // O(n) time | O(n) space
    public static String shortenPath(String path) {
        // Write your code here;
        boolean isAbs = path.charAt(0) == '/';

        String[] splitPath = path.split("/");
        List<String> filterList = new ArrayList<>();

        for (String element : splitPath) {
            if (element.equals("") || element.equals(".")) {
                continue;
            }
            filterList.add(element);
        }

        Stack<String> stack = new Stack<>();
        if (isAbs) {
            stack.push("");
        }

        for (String element : filterList) {
            if (element.equals("..")) {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else {
                    if (!stack.peek().equals("")) {
                        if (stack.peek().equals("..")) {
                            stack.push(element);
                        } else {
                            stack.pop();
                        }
                    }
                }
            } else {
                stack.push(element);
            }
        }

        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            String element = stack.pop();
            if (element.equals("")) {
                continue;
            }
            result.add(element);
        }

        int idx = result.size() - 1;
        StringBuilder resString = new StringBuilder();
        if (isAbs) {
            resString.append("/");
        }

        for (String element : result) {
            resString.append(result.get(idx));
            if (idx != 0) {
                resString.append("/");
            }
            idx--;
        }


        return resString.toString();
    }

}
