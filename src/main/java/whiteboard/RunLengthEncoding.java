package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String string = "AAAAAAAAAAAAABBCCCCDDAAAAAAA";
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        runLengthEncoding.runLengthEncoding(string);
    }

    // O(n) time | O(n) space
    public String runLengthEncoding(String string) {
        // Write your code here.
        if (string.length() == 0) {
            return string;
        }
        List<String> chars = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            int counter = 1;
            char curr = string.charAt(i);
            while (i < string.length() - 1 && string.charAt(i + 1) == curr && counter < 9) {
                counter++;
                i++;
            }
            chars.add(String.valueOf(counter));
            chars.add(String.valueOf(curr));
        }
        StringBuilder builder = new StringBuilder();
        for (String element : chars) {
            builder.append(element);
        }
        return builder.toString();
    }

}
