package july_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("neet","code","love","you");
        EncodeDecode encodeDecode = new EncodeDecode();
        String encoded = encodeDecode.encode(strs);
        List<String> decoded = encodeDecode.decode(encoded);
        System.out.println(decoded);
    }

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        // neet -> 4#neet4#code4#love3#you
        for (String str : strs) {
            builder.append(str.length());
            builder.append("#");
            builder.append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder digit = new StringBuilder();
        StringBuilder currStr = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            while (str.charAt(i) != '#' && Character.isDigit(str.charAt(i))) {
                digit.append(str.charAt(i));
                i++;
            }
            int d = Integer.parseInt(digit.toString());
            i++;
            while (d > 0) {
                currStr.append(str.charAt(i));
                i++;
                d--;
            }
            result.add(currStr.toString());
            digit.setLength(0);
            currStr.setLength(0);
        }

        return result;
    }

}
