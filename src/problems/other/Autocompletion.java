package problems.other;

import java.util.*;

public class Autocompletion {

    public static void main(String[] args) {
        String[] words = {"dog", "door", "dark", "cat", "elephant", "dodge"};

        Autocompletion autocompletion = new Autocompletion();
        autocompletion.autocompletion2(words, "do");

        autocompletion.build(words);
        List<String> result = autocompletion.autocomplete("do");
        System.out.println();
    }

    // ********
    // * STAR - G *
    // ********

    TrieNode2 trie;

    // O(n*m) time | O(n*m) space
    private void build(String[] words) {
        trie = new TrieNode2(false, new HashMap<>());
        for (String word : words) {
            TrieNode2 current = trie;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode2(false, new HashMap<>()));
                }
                current = current.children.get(c);
            }
            current.isWord = true;
        }
    }

    // O(n) time | O(n) space
    public List<String> autocomplete(String word) {
        TrieNode2 current = this.trie;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return new ArrayList<>();
            }
            current = current.children.get(c);
        }

        List<String> words = new ArrayList<>();
//        dfs(current, word, words);
        dfsIterative(current, word, words);
        return words;
    }

    private void dfs(TrieNode2 node, String prefix, List<String> words) {
        if (node.isWord) {
            words.add(prefix);
        }
        Map<Character, TrieNode2> children = node.children;
        for (Map.Entry<Character, TrieNode2> element : node.children.entrySet()) {
            Character key = element.getKey();
            String newWord = prefix + key;
            dfs(node.children.get(key), newWord, words);
        }
    }

    private void dfsIterative(TrieNode2 node, String prefix, List<String> words) {
        Stack<TrieElement> stack = new Stack<>();
        stack.push(new TrieElement(node, prefix));
        while (!stack.isEmpty()) {
            TrieElement first = stack.pop();
            TrieNode2 node1 = first.node;
            String prefix1 = first.prefix;

            if (node1.isWord) {
                words.add(prefix1);
            }

            for (Map.Entry<Character, TrieNode2> element: node1.children.entrySet()) {
                Character key = element.getKey();
                TrieNode2 child = node1.children.get(key);
                stack.push(new TrieElement(child, prefix1 + key));
            }
        }
    }

    // --------------------------
    public List<String> autocompletion2(String[] words, String substring) {
        TrieNode root = new TrieNode();
        // O(n*m) time to build Trie
        // O(n*m) space
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.key = c;
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.string = word;
        }

        TrieNode curr = root;
        for (char c : substring.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            }
            System.out.println();
        }

        List<String> result = new ArrayList<>();
        Map<Character, TrieNode> childrens = curr.children;
        for (Map.Entry<Character, TrieNode> element : childrens.entrySet()) {
            TrieNode value = element.getValue();
            Character key = value.key;
            while (value.string == null) {
                value = value.children.get(key);
                if (value != null) {
                    key = value.key;
                } else {
                    break;
                }
                System.out.println();
            }
            result.add(value.string);
        }

        return result;
    }

}

class TrieElement {
    TrieNode2 node;
    String prefix;

    public TrieElement(TrieNode2 node, String prefix) {
        this.node = node;
        this.prefix = prefix;
    }
}

class TrieNode2 {
    boolean isWord;
    Map<Character, TrieNode2> children;

    public TrieNode2(boolean isWord, Map<Character, TrieNode2> children) {
        this.isWord = isWord;
        this.children = children;
    }
}

class TrieNode {
    Character key;
    Map<Character, TrieNode> children = new HashMap<>();
    String string;
}
