package whiteboard;

import java.util.ArrayList;

public class GenerateDivTags {

    public static void main(String[] args) {
        GenerateDivTags tags = new GenerateDivTags();
        tags.generateDivTags(3);
    }

    // O((2n)!/((n!(n+1)))) time |  O((2n)!/((n!(n+1)))) time
    //      2 * n!
    // ----------------
    //   n! * (n + 1)
    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        generateDivTagsHelper("", numberOfTags, numberOfTags, result);
        return result;
    }

    private void generateDivTagsHelper(String string, int opening, int closing,
                                       ArrayList<String> result) {
        if (opening > 0) {
            String curr = string + "<div>";
            generateDivTagsHelper(curr, opening - 1, closing, result);
        }
        if (closing > opening) {
            String curr = string + "</div>";
            generateDivTagsHelper(curr, opening, closing - 1, result);
        }
        if (closing == 0) {
            result.add(string);
        }
    }

}
