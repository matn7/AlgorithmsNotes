package october_2023;

import java.util.ArrayList;
import java.util.List;

public class FindOccurrencesOfSubstring {

    public static void main(String[] args) {
        String string = "testthis is a testtest to see if testestest it works";
        String substring = "test";

        findOccurrences(string, substring);
    }

    // O(n) time | O(n) space
    public static List<int[]> findOccurrences(String string, String substring) {

        List<int[]> result = new ArrayList<>();
        int startIdx = 0;
        while (startIdx < string.length()) {
            int idx = string.indexOf(substring, startIdx);
            if (idx == -1) {
                break;
            }
            result.add(new int[] {idx, idx + substring.length()});
            startIdx = idx + 1;
        }

        return result;

    }

}
