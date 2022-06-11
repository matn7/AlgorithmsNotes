package hard;

import java.util.ArrayList;

public class GenerateDivTagsREPEAT {

    public static void main(String[] args) {
        GenerateDivTagsREPEAT generateDivTagsREPEAT = new GenerateDivTagsREPEAT();
        ArrayList<String> result = generateDivTagsREPEAT.generateDivTags(2);
        System.out.println();
    }

    // O((2n!)/(n!*(n+1)!)) time | O((2n!)/(n!*(n+1)!)) space
    // OK - repeated 04/02/2022
    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> matchedDivTags = new ArrayList<>();
        generateDivTagsFromPrefix(numberOfTags, numberOfTags, "", matchedDivTags);
        return matchedDivTags;
    }

    // rec(0, 0, "<div><div></div></div>") *
    // rec(0, 1, "<div><div></div>") *
    // rec(0, 2, "<div><div>") *

    // rec(0, 0, "<div></div><div></div>")
    // rec(0, 1, "<div></div><div>")
    // rec(1, 1, "<div></div>")
    // rec(1, 2, "<div>")
    // rec(2, 2, "")
    public void generateDivTagsFromPrefix(int openingTagsNeeded, int closingTagsNeeded, String prefix,
                                          ArrayList<String> result) {
        if (openingTagsNeeded > 0) {
            String newPrefix = prefix + "<div>";
            generateDivTagsFromPrefix(openingTagsNeeded - 1, closingTagsNeeded, newPrefix, result);
        }

        if (openingTagsNeeded < closingTagsNeeded) {
            String newPrefix = prefix + "</div>";
            generateDivTagsFromPrefix(openingTagsNeeded, closingTagsNeeded - 1, newPrefix, result);
        }

        if (closingTagsNeeded == 0) {
            result.add(prefix); // ["<div><div></div></div>", "<div></div><div></div>"]
        }
    }

}
