package november_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("neet", "code", "", "love", "you", "majjjakkka;", "a");

//        List<String> strs = Arrays.asList("VeryLongStringWithoutAnySpacesOrSpecialCharactersRepeatedManyTimesVeryLongStringWithoutAnySpacesOrSpecialCharactersRepeatedManyTimes");

        EncodeDecode encodeDecode = new EncodeDecode();
        String encoded = encodeDecode.encode(strs);
        System.out.println(encoded);

        List<String> decoded = encodeDecode.decode(encoded);
        System.out.println(decoded);
    }

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        builder.append(";");
        for (String str : strs) {
            int len = str.length();
            builder.append(len);
            builder.append(";");
            builder.append(str);
            builder.append(";");
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (index < str.length()) {
            index++;
            if (index == str.length()) {
                break;
            }
            StringBuilder lenBuilder = new StringBuilder();
            while (str.charAt(index) != ';') {
                lenBuilder.append(str.charAt(index));
                index++;
            }

            int len = Integer.parseInt(lenBuilder.toString());
            while (len > 0) {
                index++;
                builder.append(str.charAt(index));
                len--;
            }
            index++; // ignore ;
            decoded.add(builder.toString());
            builder.setLength(0); // reset builder
        }

        return decoded;
    }

}
