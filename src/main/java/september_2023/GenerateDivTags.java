package september_2023;

import java.util.ArrayList;

public class GenerateDivTags {

    public static void main(String[] args) {
        GenerateDivTags generateDivTags = new GenerateDivTags();
        generateDivTags.generateDivTags(3);
    }

    // O((2n!)/(n!*(n+1)!)) time | O((2n!)/(n!*(n+1)!)) space
    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        generateDivTagsHelper(numberOfTags, 0, 0, "", result);
        return result;
    }

    private void generateDivTagsHelper(int numberOfTags, int open, int close, String curr, ArrayList<String> result) {
        if (open < numberOfTags) {
            String newCurr = curr + "<div>";
            generateDivTagsHelper(numberOfTags, open + 1, close, newCurr, result);
        }
        if (close < open) { // <></>
            String newCurr = curr + "</div>";
            generateDivTagsHelper(numberOfTags, open, close + 1, newCurr, result);
        }
        if (open + close == 2 * numberOfTags) {
            result.add(curr);
        }
    }

}
