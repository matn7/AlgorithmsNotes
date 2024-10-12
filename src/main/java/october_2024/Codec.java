package october_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String encode = codec.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encode);
        String decode = codec.decode(encode);
        System.out.println(decode);
    }

    Map<String, String> shortUrlMap = new HashMap<>();
    Map<String, String> longUrlMap = new HashMap<>();

    String tinyUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrlMap.containsKey(longUrl)) {
            return longUrlMap.get(longUrl); // ABC
        }
        String random = getHash(); // ABC
        // http://tinyurl.com/4e9iAk
        String key = tinyUrl + random;
        shortUrlMap.put(key, longUrl);
        longUrlMap.put(longUrl, key);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrlMap.containsKey(shortUrl)) {
            return shortUrlMap.get(shortUrl);
        }
        return "";
    }

    private String getHash() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprstuwxyz1234567890";
        StringBuilder hash = new StringBuilder();
        Random random = new Random();
        while (hash.length() < 6) {
            int index = (int) (random.nextFloat() * chars.length());
            hash.append(chars.charAt(index));
        }
        return hash.toString();

    }
}
