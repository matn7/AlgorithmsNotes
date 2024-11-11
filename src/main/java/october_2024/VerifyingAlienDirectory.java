package october_2024;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDirectory {

    public static void main(String[] args) {
//        String[] words = {"hello","leetcode"};
//        String order = "hlabcdefgijkmnopqrstuvwxyz";

        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";

        VerifyingAlienDirectory verifyingAlienDirectory = new VerifyingAlienDirectory();
        boolean result = verifyingAlienDirectory.isAlienSorted(words, order);
        System.out.println(result);


    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderInd = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderInd.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            for (int j = 0; j < w1.length(); j++) {
                if (j == w2.length()) {
                    return false;
                }

                if (w1.charAt(j) != w2.charAt(j)) {
                    if (orderInd.get(w2.charAt(j)) < orderInd.get(w1.charAt(j))) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

}
