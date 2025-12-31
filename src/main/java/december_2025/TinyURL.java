package december_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyURL {

    // Mapowanie między skróconymi a oryginalnymi URL-ami
    private Map<String, String> map;
    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;
    private Random random;

    public TinyURL() {
        map = new HashMap<>();
        random = new Random();
    }

    // Funkcja do generowania unikalnego skrótu
    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrl.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return shortUrl.toString();
    }

    // Kodowanie: Zamienia długi URL na krótki
    public String encode(String longUrl) {
        String shortUrl;
        // Sprawdzamy, czy dany URL już ma przypisany skrót
        if (map.containsValue(longUrl)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals(longUrl)) {
                    return BASE_URL + entry.getKey();
                }
            }
        }

        // Generowanie nowego skrótu
        do {
            shortUrl = generateShortUrl();
        } while (map.containsKey(shortUrl)); // Zapewniamy unikalność
        map.put(shortUrl, longUrl); // Przypisanie URL-a
        return BASE_URL + shortUrl;
    }

    // Dekodowanie: Zamienia krótki URL na długi
    public String decode(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return map.get(shortKey);
    }

}
