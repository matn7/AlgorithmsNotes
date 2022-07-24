package whiteboard;

import java.util.ArrayList;

public class GenerateDivTags2 {

    public static void main(String[] args) {
        GenerateDivTags2 generate = new GenerateDivTags2();
        generate.generateDivTags(3);
    }

    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        generateDivTagsHelper(numberOfTags, numberOfTags, "", result);
        return result;
    }

    private void generateDivTagsHelper(int numOpening, int numClosing, String curr, ArrayList<String> result) {
        if (numOpening > 0) {
            String currStr = curr + "<div>";
            generateDivTagsHelper(numOpening - 1, numClosing, currStr, result);
        }
        if (numClosing > numOpening) {
            String currStr = curr + "</div>";
            generateDivTagsHelper(numOpening, numClosing - 1, currStr, result);
        }
        if (numClosing == 0) {
            result.add(curr);
        }
    }

}
