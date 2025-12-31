package december_2025;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("WorldWorldWorldWorld");

        Codec codec = new Codec();
        String encoded = codec.encode(strs);
        List<String> decoded = codec.decode(encoded);
        System.out.println(decoded);
    }


    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String str : strs) {
            int len = str.length();
            builder.append(len);
            builder.append("#");
            builder.append(str);
        }

        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int x = i;
            while (Character.isDigit(s.charAt(i))) {
                i++;
            }
            int numOfChars = Integer.parseInt(s.substring(x, i));
            // exclude separator '#'
            i++;
            String sub = s.substring(i, i + numOfChars);
            decoded.add(sub);
            i = i + numOfChars;
        }
        return decoded;
    }


}
