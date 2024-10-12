package problems.easy;

public class CesarCipherEncryptor {

    public static void main(String[] args) {
        caesarCypherEncryptor("xyz", 2);
    }

    // O(n) time | O(n) space
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        char[] encoded = new char[str.length()];
        key = key % 26;

        for (int i = 0; i < str.length(); i++) {
            int ncl = (int) str.charAt(i) + key;
            if (ncl <= 122) {
                encoded[i] = (char) ncl;
            } else {
                int shift = 96 + ncl % 122;
                encoded[i] = (char) shift;
            }
        }

        return String.valueOf(encoded);
    }
}
