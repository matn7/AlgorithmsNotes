package march_2025;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
        List<String> strs = List.of("neet","code","love","you");

        EncodeDecode encodeDecode = new EncodeDecode();
        String encode = encodeDecode.encode(strs);
        List<String> result = encodeDecode.decode(encode);
        System.out.println(result);
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
        int s = 0;
        while (i < str.length()) {
            s = i;
            while (str.charAt(i) != '#') {
                i++;
            }
            int num = Integer.valueOf(str.substring(s, i));
            i++;
            s = i;
            String sub = str.substring(s, s + num);
            result.add(sub);
            i = s + num;
        }

        return result;
    }

}
