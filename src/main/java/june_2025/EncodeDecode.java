package june_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
//        List<String> strs = Arrays.asList("neet", "code", "love", "you");
        List<String> strs = Arrays.asList("1,23","45,6","7,8,9");

        EncodeDecode encodeDecode = new EncodeDecode();
        String encoded = encodeDecode.encode(strs);
        List<String> decoded = encodeDecode.decode(encoded);
        System.out.println(decoded);
    }

    // O(m) time | O(n + m) space
    // m - sum of lengths
    // n - num of strings
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length());
            builder.append("#");
            builder.append(str);
        }

        return builder.toString();
    }

    // O(m) time | O(n + m) space
    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // check number
            StringBuilder numBuilder = new StringBuilder();
            while (Character.isDigit(str.charAt(i))) {
                numBuilder.append(str.charAt(i));
                i++;
            }
            i++;
            int num = Integer.parseInt(numBuilder.toString());
            StringBuilder strBuilder = new StringBuilder();
            int stop = num + i;
            while (i < stop) {
                strBuilder.append(str.charAt(i));
                i++;
            }
            decoded.add(strBuilder.toString());
        }

        return decoded;
    }


}
