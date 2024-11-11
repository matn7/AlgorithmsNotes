package november_2024;


import java.util.Stack;

public class DecodeString2 {

    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
        String s = "3[a2[c]]";
        DecodeString2 decodeString2 = new DecodeString2();
        String result = decodeString2.decodeString(s);
        System.out.println(result);
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String digits = "0123456789";

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar != ']') {
                stack.push(String.valueOf(currentChar));
            } else {
                StringBuilder subBuilder = new StringBuilder();
                // Build the substring from the stack until we find '['
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    subBuilder.insert(0, stack.pop());
                }
                // Remove the '[' from the stack
                stack.pop();

                // Now build the number k from the stack
                StringBuilder kBuilder = new StringBuilder();
                while (!stack.isEmpty() && digits.contains(stack.peek())) {
                    kBuilder.insert(0, stack.pop());
                }
                // Convert the string k to an integer
                int k = Integer.parseInt(kBuilder.toString());

                // Push the substring k times onto the stack
                String substr = subBuilder.toString();
                for (int j = 0; j < k; j++) {
                    stack.push(substr);
                }
            }
        }

        // Build the final result from the stack
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop()); // Insert at the beginning to maintain order
        }

        return res.toString();
    }

}
