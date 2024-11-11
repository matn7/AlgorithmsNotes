package november_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("lint", "code", "love", "you");
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        String encoded = encodeAndDecode.encode(input);
        List<String> decoded = encodeAndDecode.decode(encoded);
        System.out.println(decoded);
    }

    // leetcode 271 premium

    public String encode(List<String> input) {
        StringBuilder encode = new StringBuilder();
        for (String str : input) {
            encode.append(str);
            encode.append(";");
        }
        return encode.toString();
    }

    public List<String> decode(String encoded) {
        String[] split = encoded.split(";");
        List<String> res = new ArrayList<>();
        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            res.add(s);
        }
        return res;
    }


}
