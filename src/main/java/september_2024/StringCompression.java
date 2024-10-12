package september_2024;

public class StringCompression {

    public static void main(String[] args) {
        String str = "aabbbbccbccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        StringCompression stringCompression = new StringCompression();
        String result = stringCompression.compress(str);
        System.out.println(result);
    }

    // O(n) time | O(k) space
    public String compress(String str) {
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        while (idx < str.length()) {
            char c = str.charAt(idx);
            int count = 0;
            while (idx < str.length() && c == str.charAt(idx)) {
                idx++;
                count++;
            }
            builder.append(c);
            builder.append(count);

        }
        String result = builder.toString();
        if (result.length() < str.length()) {
            return result;
        }
        return str;
    }

    // Book
    // O(p + k^2) time
    String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
    }

    String compress2(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    String compress3(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

}
