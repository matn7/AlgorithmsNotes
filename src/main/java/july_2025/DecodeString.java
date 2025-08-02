package july_2025;

public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString decodeString = new DecodeString();
        String result = decodeString.decodeString(s);
        System.out.println(result);
    }

    // O(n + N) time | O(n + N) space
    private int i = 0;

    public String decodeString(String s) {
        return helper(s);
    }

    private String helper(String s) {
        StringBuilder res = new StringBuilder();
        int k = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                i++;
                String subRes = helper(s);
                while (k > 0) {
                    res.append(subRes);
                    k--;
                }
                k = 0;
            } else if (c == ']') {
                return res.toString();
            } else {
                res.append(c);
            }
            i++;
        }

        return res.toString();
    }


}
