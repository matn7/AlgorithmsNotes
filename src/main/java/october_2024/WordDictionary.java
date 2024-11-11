package october_2024;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//
//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("dad"));
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search("b.."));

        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");

        wordDictionary.search("a");

    }

    Map<Integer, Set<Character>> levelMap;
    Map<String, Boolean> words;

    public WordDictionary() {
        levelMap = new HashMap<>();
        words = new HashMap<>();
    }

    public void addWord(String word) {
        int level = 0;
        words.put(word, Boolean.TRUE);
        for (char c : word.toCharArray()) {
            if (!levelMap.containsKey(level)) {
                Set<Character> set = new HashSet<>();
                set.add(c);
                levelMap.put(level, set);
            } else {
                Set<Character> currentLevel = levelMap.get(level);
                currentLevel.add(c);
            }
            level++;
        }
    }

    public boolean search(String word) {
        int level = 0;
        for (char c : word.toCharArray()) {
            if (!levelMap.containsKey(level)) {
                return words.containsKey(word);
            }
            if (c == '.') {
                level++;
                continue;
            }
            Set<Character> characters = levelMap.get(level);
            if (!characters.contains(c)) {
                return false;
            }
            level++;
        }
        return true;
    }

}