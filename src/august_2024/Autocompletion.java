package august_2024;

import java.util.*;

public class Autocompletion {

    public static void main(String[] args) {
        String[] words = {"dog", "door", "dark", "cat", "elephant", "dodge"};
        String word = "do";

        Autocompletion autocompletion = new Autocompletion(words);
        autocompletion.autocompletion(word);

    }

    TrieNode root = new TrieNode();

    public Autocompletion(String[] words) {
        init(words);
    }

    private void init(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.fullWord = word;
        }
    }

    public List<String> autocompletion(String word) {
        TrieNode curr = root;
        List<String> result = new ArrayList<>();

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return result;
            }
            curr = curr.children.get(c);
        }

//        dfs(curr, result);
        Stack<TrieNode> stack = new Stack<>();
        stack.push(curr);
        while (!stack.isEmpty()) {
            TrieNode pop = stack.pop();
            if (pop.fullWord != null) {
                result.add(pop.fullWord);
            }
            for (Map.Entry<Character, TrieNode> element : pop.children.entrySet()) {
                stack.push(element.getValue());
            }
        }

        return result;
    }

    private void dfs(TrieNode curr, List<String> result) {
        if (curr.fullWord != null) {
            result.add(curr.fullWord);
            return;
        }
        for (Map.Entry<Character, TrieNode> element : curr.children.entrySet()) {
            TrieNode value = element.getValue();
            dfs(value, result);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String fullWord = null;
    }

}
