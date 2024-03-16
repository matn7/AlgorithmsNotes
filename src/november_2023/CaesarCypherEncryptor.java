package november_2023;

public class CaesarCypherEncryptor {

    public static void main(String[] args) {
        String str = "xyz";
        int key = 2;
        String result = caesarCypherEncryptor(str, key);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String caesarCypherEncryptor(String str, int key) {

        System.out.println((int) 'z');
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int val = c + key;
            if (val > 122) {
                val = 96 + val%122;
                builder.append((char) val);
            } else {
                builder.append((char) val);
            }
        }

        return builder.toString();
    }

}
