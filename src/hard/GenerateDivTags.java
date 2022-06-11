package hard;

import java.util.ArrayList;

public class GenerateDivTags {

    public static void main(String[] args) {
        GenerateDivTags generateDivTags = new GenerateDivTags();
        ArrayList<String> result = generateDivTags.generateDivTags(2);
        System.out.println();
    }

    // O((2n!)/(n!*(n+1)!)) time | O((2n!)/(n!*(n+1)!)) space
    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> matchedDivTags = new ArrayList<>();

        generateDivTagsFromPrefix(numberOfTags, numberOfTags, "", matchedDivTags);

        return matchedDivTags;
    }

    private void generateDivTagsFromPrefix(int openingTagsNeeded, int closingTagsNeeded,
                                           String prefix, ArrayList<String> result) {
        if (openingTagsNeeded > 0) {
            String newPrefix = prefix + "<div>";
            generateDivTagsFromPrefix(openingTagsNeeded - 1,
                    closingTagsNeeded, newPrefix, result);
        }
        if (openingTagsNeeded < closingTagsNeeded) {
            String newPrefix = prefix + "</div>";
            generateDivTagsFromPrefix(openingTagsNeeded,
                    closingTagsNeeded - 1, newPrefix, result);
        }
        if (closingTagsNeeded == 0) {
            result.add(prefix);
        }
    }

}
