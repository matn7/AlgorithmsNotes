package udemy.generalprogramming;

import java.util.ArrayList;
import java.util.List;

public class Chunkify {

    private static String DELIMITER = ":";
    private static int CHUNK_SIZE = 5;

    public static void main(String[] args) {
        String doc = "a:bb:cc:abcdef:ab:c:d:";
        List<String> result = chunkify(doc);
        System.out.println();
    }

    // a:bb:cc:abcdef:ab:c:d:
    public static List<String> chunkify(String doc) {
        // list to hold the chunks of the document
        List<String> chunkList = new ArrayList<>();

        // get the paragraphs in document
        String[] paragraphs = doc.split(DELIMITER);

        String currentChunk = "";
        for (String para : paragraphs) {
            // if adding the current paragraph exceeds chunk size, then add the chunk to the list to be returned,
            // the current paragraph should be in a new chunk
            if (currentChunk.length() + para.length() > CHUNK_SIZE) {
                if (currentChunk.length() > 0) {
                    chunkList.add(currentChunk);
                    currentChunk = "";
                }
            }

            // if the paragraph itself is longer than the chunk size then add it to a chunk by itself
            if (para.length() > CHUNK_SIZE) {
                if (currentChunk.length() > 0) {
                    chunkList.add(currentChunk);
                    currentChunk = "";
                }
                // ensure you always add the delimiter back after every paragraph otherwise paragraph boundaries
                // will be lost
                chunkList.add(para + DELIMITER);
                continue;
            }

            currentChunk += para + DELIMITER;
        }

        // add the last chunk in if it is present
        if (currentChunk.length() > 0) {
            chunkList.add(currentChunk);
        }

        return chunkList;
    }

}
