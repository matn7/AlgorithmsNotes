package july_2025;

public class MergeAlternately {

    public static void main(String[] args) {
//        String word1 = "abc", word2 = "pqr";
        String word1 = "ab", word2 = "pqrs";

        MergeAlternately mergeAlternately = new MergeAlternately();
        String result = mergeAlternately.mergeAlternately(word1, word2);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(j));
            i++;
            j++;
        }
        if (i < word1.length()) {
            builder.append(word1.substring(i));
        }
        if (j < word2.length()) {
            builder.append(word2.substring(j));
        }
        return builder.toString();
    }

}
