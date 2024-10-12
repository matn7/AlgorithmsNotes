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

    // O(n) time | O(n) space
    public static String shortenPath2(String path) {
        // Write your code here;
        if (path.equals("/")) {
            return "/";
        }
        char firstChar = path.charAt(0);
        boolean isAbsolutePath = false; // /../../../foo/bar/baz
        if (firstChar == '/') {
            isAbsolutePath = true;
        }
        String[] pathsElements = path.split("/");
        List<String> pathsFilteredElements = new ArrayList<>();
        for (String elem : pathsElements) {
            if (elem.equals("") || elem.equals(".")) {
                continue;
            }
            pathsFilteredElements.add(elem);
        }
        Stack<String> stack = new Stack<>();
        if (isAbsolutePath) {
            stack.push("");
        }

        for (String elem : pathsFilteredElements) {
            if (elem.equals("..")) {
                if (stack.isEmpty()) {
                    stack.push(elem);
                } else {
                    if (!stack.peek().equals("")) {
                        if (stack.peek().equals("..")) {
                            stack.push(elem);
                        } else {
                            stack.pop();
                        }
                    }
                }
            } else {
                stack.push(elem);
            }
        }
        if (stack.size() == 1 && stack.get(0).equals("")) {
            return "/";
        }

        String result = "".join("/", stack);
        return result;
    }

}
