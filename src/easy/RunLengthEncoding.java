package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String string = "AAAAAAAAAAAAABBCCCCDD";
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        runLengthEncoding.runLengthEncoding(string);
    }

    // OK - repeated 04/03/2022
    // O(n) time | O(n) space
    public String runLengthEncoding(String string) {
        // Write your code here.
        int length = 1;
        //                                           i
        // A A A A A A A A A A A A A B B C C C C D D
        List<String> chars = new ArrayList<>();
        // [9, A, 4, A, 2, B, 4, C, 2, D]
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1) && length < 9) { // D == D && 1 < 9
                length++; // 2
            } else {
                chars.add(String.valueOf(length));
                chars.add(String.valueOf(string.charAt(i - 1)));
                length = 1;
            }
        }

        chars.add(String.valueOf(length));
        chars.add(String.valueOf(string.charAt(string.length() - 1)));

        final String collect = String.join("", chars); // "9A4A2B4C2D"

        return collect;
    }

}
