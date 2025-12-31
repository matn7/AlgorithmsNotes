package december_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL encodeAndDecodeTinyURL = new EncodeAndDecodeTinyURL();
        System.out.println(Math.pow(62, 5));

        String longUrl = "https://leetcode.com/problems/design-tinyurl";

        String encoded = encodeAndDecodeTinyURL.encode(longUrl);

        String decoded = encodeAndDecodeTinyURL.decode(encoded);
        System.out.println(decoded);

    }

    // longUrl = https://leetcode.com/problems/design-tinyurl
    // encoded = https://tinyurl.com/4e9iAk
    private static final String SHORT_URL = "https://tinyurl.com/";
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Map<String, String> urlMap;
    Random random;

    public EncodeAndDecodeTinyURL() {
        random = new Random();
        urlMap = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder builder = new StringBuilder();
        builder.append(SHORT_URL);
        for (int i = 0; i < 5; i++) {
            int randomIdx = random.nextInt(CHARACTERS.length());
            builder.append(CHARACTERS.charAt(randomIdx));
        }

        String key = builder.toString();

        if (urlMap.containsKey(key)) {
            // collision
            return encode(longUrl);
        }
        urlMap.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (!urlMap.containsKey(shortUrl)) {
            // no such key in url database
            return "";
        }
        return urlMap.get(shortUrl);
    }

}
