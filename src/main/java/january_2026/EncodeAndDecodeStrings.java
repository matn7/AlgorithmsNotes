package january_2026;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        List<String> strs = List.of("Hellooooooooooooooooooooo","World");

        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        String encoded = encodeAndDecodeStrings.encode(strs);
        List<String> decoded = encodeAndDecodeStrings.decode(encoded);
        System.out.println(decoded);

    }

    // O(n) time | O(n) space
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length());
            builder.append("#");
            builder.append(str);
        }
        return builder.toString();

    }

    // O(n) time | O(n) space
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            StringBuilder numBuilder = new StringBuilder();
            while (s.charAt(i) != '#') {
                numBuilder.append(s.charAt(i));
                i++;
            }
            i++;
            int num = Integer.parseInt(numBuilder.toString());;
            String substr = s.substring(i, i + num);
            result.add(substr);
            i = i + num;
        }
        return result;
    }

}
