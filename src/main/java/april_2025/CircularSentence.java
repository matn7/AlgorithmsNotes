package april_2025;

import java.util.ArrayList;
import java.util.List;

public class CircularSentence {

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";

        CircularSentence circularSentence = new CircularSentence();
        boolean result = circularSentence.isCircularSentence(sentence);
        System.out.println(result);
    }

    public boolean isCircularSentence(String sentence) {
        if (sentence.isEmpty()) {
            return true;
        }
        String[] split = sentence.split(" ");
        List<char[]> array = new ArrayList<>();
        for (String s : split) {
            array.add(new char[] {s.charAt(0), s.charAt(s.length() - 1)});
        }

        for (int i = 1; i < array.size(); i++) {
            char[] prev = array.get(i - 1);
            char[] curr = array.get(i);
            if (prev[1] != curr[0]) {
                return false;
            }
        }
        return array.get(0)[0] == array.get(array.size() - 1)[1];
    }

}
