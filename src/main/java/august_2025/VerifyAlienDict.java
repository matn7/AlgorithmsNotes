package august_2025;

public class VerifyAlienDict {

    public static void main(String[] args) {
//        String[] words = {"word","world","row"};
//        String order = "worldabcefghijkmnpqstuvxyz";

//        String[] words = {"hello","leetcode"};
//        String order = "hlabcdefgijkmnopqrstuvwxyz";

        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        VerifyAlienDict verifyAlienDict = new VerifyAlienDict();
        boolean result = verifyAlienDict.isAlienSorted(words, order);
        System.out.println(result);
    }

    // O(n * l) time | O(1) space
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabet = new int[26];

        for (int i = 0; i < order.length(); i++) {
            int c = order.charAt(i) - 'a';
            alphabet[c] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                int c1 = word1.charAt(j) - 'a';
                int c2 = word2.charAt(j) - 'a';
                if (alphabet[c1] < alphabet[c2]) { // c1 < c2 already sorted
                    break;
                } else if (alphabet[c1] > alphabet[c2]) { // c1 > c2 wrong order
                    return false;
                } else { // c1 == c2 the same check next char
                    if (word1.length() > word2.length() && j == word2.length() - 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
