package september_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("neet","codepppppppppppppppanda","love","you");
        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        String encoded = encodeAndDecodeStrings.encode(strs);
        List<String> decoded = encodeAndDecodeStrings.decode(encoded);
        System.out.println(decoded);
    }

    // O(n) time | O(n) space
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String string : strs) {
            builder.append("#");
            int length = string.length();
            builder.append(length);
            builder.append("#");
            builder.append(string);
        }
        return builder.toString();
    }

    // O(n) time | O(n) space
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        while (idx < str.length()) {
            // skip first '#' in new sequence
            if (str.charAt(idx) == '#') {
                idx++;
            }
            // determine number of chars
            int wordLength = 0;
            while (Character.isDigit(str.charAt(idx))) {
                int digit = Character.getNumericValue(str.charAt(idx));
                wordLength = 10 * wordLength + digit;
                idx++;
            }
            // skip second '#' in new sequence (border of how many chars)
            idx++;
            String seqStr = str.substring(idx, idx + wordLength);
            result.add(seqStr);
            idx = idx + wordLength;
        }
        return result;
    }

}
