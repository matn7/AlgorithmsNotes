package november_2024;

public class DecodeString {

    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
        String s = "3[a2[c]]";

        DecodeString decodeString = new DecodeString();
        String result = decodeString.decodeString(s);
        System.out.println(result);
    }


    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        helper(s, 0, builder);
        return builder.toString();
    }

    private void helper(String s, int index, StringBuilder builder) {
        if (index >= s.length()) {
            return;
        }
        int num = 0;
        int dig = 1;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num += (Character.getNumericValue(s.charAt(index))) * dig;
            index++;
            dig *= 10;
        }
        StringBuilder seq = new StringBuilder();
        // (omit [ after digit)
        index++;
        while (index < s.length() && s.charAt(index) != ']' && !Character.isDigit(s.charAt(index))) {
            seq.append(s.charAt(index));
            index++;
        }
        String seqStr = seq.toString();
        for (int i = 0; i < num; i++) {
            builder.append(seqStr);
            if (index < s.length() && Character.isDigit(s.charAt(index))) {
                // nested
                helper(s, index, builder);
            }
        }
        helper(s, index, builder);
    }

}
