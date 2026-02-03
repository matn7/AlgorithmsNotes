package january_2026;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec2 {

    private static String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String TINY_URL = "http://tinyurl.com/";
    private Random random = new Random();
    private int hashLength = 6;
    private Map<String, String> urlDatabase = new HashMap<>();

    // O(l) time | O(n) space
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // input: https://leetcode.com/problems/design-tinyurl
        // output: http://tinyurl.com/4e9iAk

        // [0-9a-zA-z]
        // 26 + 26 + 10 = 62 chars
        // 62^6
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hashLength; i++) {
            int randomIdx = random.nextInt(CHARACTERS.length());
            builder.append(CHARACTERS.charAt(randomIdx));
        }
        String key = TINY_URL + builder;
        if (urlDatabase.containsKey(key)) {
            // conflict repeat process
            return encode(longUrl);
        }
        urlDatabase.put(key, longUrl);
        return key;
    }

    // O(1) time | O(1) space
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // input: http://tinyurl.com/4e9iAk
        // output: https://leetcode.com/problems/design-tinyurl
        return urlDatabase.getOrDefault(shortUrl, "");
    }

}
