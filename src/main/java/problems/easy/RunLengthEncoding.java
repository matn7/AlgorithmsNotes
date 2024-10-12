package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String string = "AAAAAAAAAAAAABBCCCCDD";
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        runLengthEncoding.runLengthEncoding(string);
    }

    // O(n) time | O(n) space
    public String runLengthEncoding(String string) {
        // Write your code here.
        int length = 1;
        List<String> chars = new ArrayList<>();
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1) && length < 9) {
                length++;
            } else {
                chars.add(String.valueOf(length));
                chars.add(String.valueOf(string.charAt(i - 1)));
                length = 1;
            }
        }

        chars.add(String.valueOf(length));
        chars.add(String.valueOf(string.charAt(string.length() - 1)));

        final String collect = String.join("", chars);

        return collect;
    }

}
