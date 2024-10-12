package june_2024;

import java.util.HashMap;
import java.util.Map;

public class PrefixTrieConstruction implements PrefixTrie3 {

    Node root = new Node();

    public PrefixTrieConstruction(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    @Override
    public void insert(String word) {
        insertHelper(word, this.root);
    }

    private void insertHelper(String word, Node node) {
        if (word.length() == 0) {
            node.end = true;
            return;
        }
        if (!node.children.containsKey(word.charAt(0))) {
            node.children.put(word.charAt(0), new Node());
        }
        insertHelper(word.substring(1), node.children.get(word.charAt(0)));
    }

//    @Override
//    public void insert(String word) {
//        Node current = this.root;
//        for (char c : word.toCharArray()) {
//            if (!current.children.containsKey(c)) {
//                current.children.put(c, new Node());
//            }
//            current = current.children.get(c);
//        }
//        current.end = true;
//
//    }

    @Override
    public boolean search(String word) {
        Node current = this.root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }

        return searchHelper(word, this.root);
    }

    private boolean searchHelper(String word, Node node) {
        if (word.length() == 0 && node.end) {
            return true;
        }
        if (word.length() == 0) {
            return false;
        }
        if (!node.children.containsKey(word.charAt(0))) {
            return false;
        }
        return searchHelper(word.substring(1), node.children.get(word.charAt(0)));
    }

//    @Override
//    public boolean search(String word) {
//        Node current = this.root;
//
//        for (char c : word.toCharArray()) {
//            if (!current.children.containsKey(c)) {
//                return false;
//            }
//            current = current.children.get(c);
//        }
//
//        return current.end;
//    }

    @Override
    public boolean startsWith(String word) {
        return startsWithHelper(word, this.root);
    }

    private boolean startsWithHelper(String word, Node node) {
        if (word.length() == 0) {
            return true;
        }
        if (!node.children.containsKey(word.charAt(0))) {
            return false;
        }
        return startsWithHelper(word.substring(1), node.children.get(word.charAt(0)));
    }

//    @Override
//    public boolean startsWith(String word) {
//        Node current = this.root;
//
//        for (char c : word.toCharArray()) {
//            if (!current.children.containsKey(c)) {
//                return false;
//            }
//            current = current.children.get(c);
//        }
//
//        return true;
//    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean end;
    }

}

class Main {
    public static void main(String[] args) {
        String[] words = {"majka", "aja", "maja", "sebastian", "sebix", "puszek", "pusz"};
        PrefixTrieConstruction prefixTrie = new PrefixTrieConstruction(words);

        boolean search = prefixTrie.search("maja");
        System.out.println(search);

    }
}

interface PrefixTrie3 {

    void insert(String word);

    boolean search(String word);

    boolean startsWith(String word);

}
