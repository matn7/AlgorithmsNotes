package january_2024;

import java.util.*;

public class AutoCompletion {

    public static void main(String[] args) {
        String[] words = {"dog", "door", "dark", "cat", "elephant", "dodge"};
        String substring = "do";

        List<String> strings = autoCompletion(words, substring);
        System.out.println();
    }

    // O(n*m) time | O(n*m) space
    public static List<String> autoCompletion(String[] words, String substring) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie(words);
        TrieNode node = trie.findNode(substring);
        if (node == null) {
            return result;
        }

//        dfs(node, substring, result);
        dfsIterative(node, substring, result);

        return result;
    }

    private static void dfs(TrieNode node, String word, List<String> result) {
        if (node.endSymbol == '*') {
            result.add(word);
            return;
        }
        for (Map.Entry<Character, TrieNode> element : node.children.entrySet()) {
            String newWord = word + element.getKey();
            dfs(element.getValue(), newWord, result);
        }
    }

    private static void dfsIterative(TrieNode node, String prefix, List<String> result) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(node, prefix));

        while (!stack.isEmpty()) {
            NodeInfo current = stack.pop();
            TrieNode currentNode = current.node;
            String currentPrefix = current.prefix;
            if (currentNode.endSymbol == '*') {
                result.add(currentPrefix);
            }
            for (Map.Entry<Character, TrieNode> element : currentNode.children.entrySet()) {
                TrieNode child = element.getValue();
                stack.push(new NodeInfo(child, prefix + element.getKey()));
            }
        }
    }

    static class NodeInfo {
        TrieNode node;
        String prefix;

        public NodeInfo(TrieNode node, String prefix) {
            this.node = node;
            this.prefix = prefix;
        }
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public Trie(String[] words) {
            for (String word : words) {
                insert(word);
            }
        }

        private void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
                curr.count++;
            }
            curr.endSymbol = '*';
        }

        public TrieNode findNode(String str) {
            TrieNode curr = root;
            for (char c : str.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return null;
                }
                curr = curr.children.get(c);
            }
            return curr;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count;
        char endSymbol;
    }

}
