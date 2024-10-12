package star;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {
        String str = "acdbacdacb";
        String anagram = "abc";

        FindAnagrams findAnagrams = new FindAnagrams();
        findAnagrams.find_anagrams(str, anagram);
    }

    // O(n * n!) time | O(n * n!) space
    public List<Integer> find_anagrams(String a, String b) {
        if (a.length() < b.length()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        List<String> permut = new ArrayList<>();
        List<String> bArr = new ArrayList<>();
        for (int i = 0; i < b.length(); i++) {
            bArr.add(String.valueOf(b.charAt(i)));
        }
        findPermut(new ArrayList<>(), bArr, permut);

        for (String s : permut) {
            if (a.contains(s)) {
                result.add(a.indexOf(s));
            }
        }

        return result;
    }

    private void findPermut(List<String> str, List<String> curr, List<String> permut) {
        if (curr.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (String s : str) {
                builder.append(s);
            }
            permut.add(builder.toString());
        } else {
            for (int i = 0; i < curr.size(); i++) {
                List<String> newCurr = new ArrayList<>(curr);
                String removed = newCurr.remove(i);
                List<String> newStr = new ArrayList<>(str);
                newStr.add(removed);
                findPermut(newStr, newCurr, permut);
            }
        }

    }

}
