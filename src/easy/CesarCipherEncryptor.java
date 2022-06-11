package easy;

public class CesarCipherEncryptor {

    public static void main(String[] args) {
        caesarCypherEncryptor("xyz", 2);
    }

    // OK - repeated 03/03/2022
    // O(n) time | O(n) space
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        // encoded = ['', '', '']
        char[] encoded = new char[str.length()];
        key = key % 26; // cover case when key is large = 2
        System.out.println((int) 'x');
        System.out.println((int) 'y');
        System.out.println((int) 'z');
        System.out.println((char) 97);

        for (int i = 0; i < str.length(); i++) {
            //     *
            // x y z
            // z a b
            int ncl = (int) str.charAt(i) + key; // 122 + 2 = 124
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
