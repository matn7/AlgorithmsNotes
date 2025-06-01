package may_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("neet","code","love","you");
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        String encoded = encodeAndDecode.encode(strs);
        List<String> decoded = encodeAndDecode.decode(encoded);
        System.out.println(decoded);
    }


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

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (Character.isDigit(str.charAt(j))) {
                j++;
            }
            String digitStr = str.substring(i, j);
            int digit = Integer.parseInt(digitStr);
            j++;
            String s = str.substring(j, j + digit);
            result.add(s);
            i = j + digit;
        }
        return result;
    }

}
