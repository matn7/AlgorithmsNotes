package july_2024;

import java.util.*;

public class Autocompletion {

    public static void main(String[] args) {
        String[] words = {"dog", "door", "dark", "cat", "elephant", "dodge"};

        Autocompletion autocompletion = new Autocompletion(words);
        List<String> result = autocompletion.autocomplete("do");
        System.out.println(result);
    }

    TrieNode trie;

    public Autocompletion(String[] words) {
        build(words);
    }

    // O(n*m) time | O(n*m) space
    private void build(String[] words) {
        trie = new TrieNode(false);
        for (String word : words) {
            TrieNode curr = trie;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode(false));
                }
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }
    }

    // O(p + s) space
    public List<String> autocomplete(String word) {
        TrieNode curr = this.trie;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return new ArrayList<>();
            }
            curr = curr.children.get(c);
        }
        List<String> words = new ArrayList<>();
//        dfs(curr, word, words);
        dfsIterative(curr, word, words);
        return words;
    }

    private void dfs(TrieNode node, String prefix, List<String> words) {
        if (node.isWord) {
            words.add(prefix);
        }
        for (Map.Entry<Character, TrieNode> element : node.children.entrySet()) {
            Character key = element.getKey();
            String newWord = prefix + key;
            dfs(node.children.get(key), newWord, words);
        }
    }

    private void dfsIterative(TrieNode node, String prefix, List<String> words) {
        Stack<TrieElement> stack = new Stack<>();
        stack.push(new TrieElement(node, prefix));

        while (!stack.isEmpty()) {
            TrieElement elem = stack.pop();
            TrieNode n = elem.node;
            String p = elem.prefix;

            if (n.isWord) {
                words.add(p);
            }
            for (Map.Entry<Character, TrieNode> element : n.children.entrySet()) {
                Character key = element.getKey();
                TrieNode child = n.children.get(key);
                stack.push(new TrieElement(child, p + key));
            }
        }
    }

    static class TrieElement {
        TrieNode node;
        String prefix;

        public TrieElement(TrieNode node, String prefix) {
            this.node = node;
            this.prefix = prefix;
        }
    }

    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(boolean isWord) {
            this.isWord = isWord;
        }
    }

}
