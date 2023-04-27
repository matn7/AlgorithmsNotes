package star;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Autocompletion {

    Trie trie;

    public Autocompletion(String[] words) {
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
    }

    public List<String> autocompletion(String str) {
        TrieNode curr = trie.node;
        for (char c : str.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return null;
            }
            curr = curr.children.get(c);
        }

        // Add recursive impl
        TrieNode curr1 = curr;
        List<String> result = new ArrayList<>();
        dfs(result, curr1);
//        for (Map.Entry<Character, TrieNode> elem : curr1.children.entrySet()) {
//            TrieNode value = elem.getValue();
//            char key = value.id;
//            while (!value.children.containsKey('*')) {
//                value = value.children.get(key);
//                key = value.id;
//            }
//            result.add(value.word);
//        }

        return result;
    }

    private void dfs(List<String> result, TrieNode node) {
        if (node == null) {
            return;
        }
        if (!node.word.equals("")) {
            result.add(node.word);
        }
        Map<Character, TrieNode> children = node.children;
        for (Map.Entry<Character, TrieNode> elem : children.entrySet()) {
            Character key = elem.getKey();
            dfs(result, children.get(key));
        }
    }


    static class Trie {
        TrieNode node = new TrieNode();

        public void insert(String word) {
            TrieNode curr = node;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr.id = c;
                curr = curr.children.get(c);
            }

            curr.id = '*';
            curr.children.put('*', null);
            curr.word = word;
        }
    }


    static class TrieNode {
        Character id;
        Map<Character, TrieNode> children = new HashMap<>();
        String word = "";
    }
}
