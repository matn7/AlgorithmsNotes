package coderpro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ShortestUniquePrefix {

    public static void main(String[] args) {
        String[] words = { "jon", "john", "jack", "techlead" };

        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        shortestUniquePrefix.shortest_unique_prefix(words);
    }

    // O(n) time | O(n) space
    public List<String> shortest_unique_prefix(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> unique_prefixes = new ArrayList<>();
        for (String word : words) {
            unique_prefixes.add(trie.unique_prefix(word));
        }

        return unique_prefixes;
    }

    // ============================
    // O(n*m) time | O(n*m) space
    public List<String> uniquePrefix(String[] words) {

        TrieNode3 root = new TrieNode3();

        for (String word : words) {
            TrieNode3 current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode3());
                }
                current.count++;
                current = current.children.get(c);
            }
            current.count++;
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            TrieNode3 current = root;
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                builder.append(c);
                TrieNode3 currTrieNode = current.children.get(c);
                if (currTrieNode.count == 1) {
                    String oneResult = builder.toString();
                    result.add(oneResult);
                    break;
                }
                current = current.children.get(c);
            }
        }

        return result;
    }

}

class Trie {
    TrieNode3 root = new TrieNode3();

    public void insert(String word) {
        TrieNode3 node = this.root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode3());
            }
            node = node.children.get(c);
            node.count++;
        }
    }

    public String unique_prefix(String word) {
        TrieNode3 node = this.root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (node.count == 1) {
                return prefix.toString();
            } else {
                node = node.children.get(c);
                prefix.append(c);
            }
        }
        return prefix.toString();
    }
}

class TrieNode3 {

    int count;
    Map<Character, TrieNode3> children = new HashMap<>();

}
