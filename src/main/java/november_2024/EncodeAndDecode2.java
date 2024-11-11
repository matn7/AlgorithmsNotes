package november_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode2 {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("lint", "code", "love", "you");
        EncodeAndDecode2 encodeAndDecode = new EncodeAndDecode2();
        String encoded = encodeAndDecode.encode(input);
        List<String> decoded = encodeAndDecode.decode(encoded);
        System.out.println(decoded);
    }

    // leetcode 271 premium

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for (String s : strs) {
            encode.append(s.length());
            encode.append("#");
            encode.append(s);
        }

        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }

        return res;
    }


}
