package december_2025;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Helloooooooooooooooooox");
        strs.add("World");

        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        String encoded = encodeAndDecodeStrings.encode(strs);

        List<String> decoded = encodeAndDecodeStrings.decode(encoded);
        System.out.println(decoded);
    }

    // O(n) time | O(n) space
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        char separator = '#';
        for (String str : strs) {
            int length = str.length();
            builder.append(length);
            builder.append(separator);
            builder.append(str);
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            // check word len
            StringBuilder digit = new StringBuilder();
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                digit.append(s.charAt(i));
                i++;
            }
            int wordLen = Integer.parseInt(digit.toString());
            i++;
            String word = s.substring(i, i + wordLen);
            result.add(word);
            i = i + wordLen;
        }

        return result;
    }

}
