package hard;

import medium.SuffixTrieConstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoggleBoard {

    public static void main(String[] args) {
        char[][] board = {
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        };

        String[] words = {"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};

        boggleBoard(board, words);
    }

    // O(w*s + n*m*8^s) | O(w*s + n*m) space (w words, s longest word, n width of matrix, m height of matrix)
    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        Map<String, Character> finalWords = new HashMap<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                explore(i, j, board, trie.root, visited, finalWords);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Character> element : finalWords.entrySet()) {
            result.add(element.getKey());
        }

        return result;
    }

    private static void explore(int i, int j, char[][] board, TrieNode trieNode, boolean[][] visited,
                         Map<String, Character> finalWords) {
        if (visited[i][j]) {
            return;
        }
        char letter = board[i][j];
        if (!trieNode.children.containsKey(letter)) {
            return;
        }
        visited[i][j] = true;
        trieNode = trieNode.children.get(letter);
        if (trieNode.children.containsKey('*')) {
            finalWords.put(trieNode.fullString.get('*'), null);
        }
        List<Coords> neighbors = getNeighbors(i, j, board);
        for (Coords neighbor : neighbors) {
            explore(neighbor.x, neighbor.y, board, trieNode, visited, finalWords);
        }
        visited[i][j] = false;
    }

    private static List<Coords> getNeighbors(int i, int j, char[][] board) {
        List<Coords> neighbors = new ArrayList<>();
        if (i > 0 && j > 0) {
            neighbors.add(new Coords(i - 1, j - 1)); //
        }
        if (i > 0 && j < board[0].length - 1) {
            neighbors.add(new Coords(i - 1, j + 1)); //
        }
        if (i < board.length - 1 && j < board[0].length - 1) {
            neighbors.add(new Coords(i + 1, j + 1)); //
        }
        if (i > 0) {
            neighbors.add(new Coords(i - 1, j)); //
        }
        if (i < board.length - 1 && j > 0) {
            neighbors.add(new Coords(i + 1, j - 1)); //
        }
        if (i < board.length - 1) {
            neighbors.add(new Coords(i + 1, j)); //
        }
        if (j > 0) {
            neighbors.add(new Coords(i, j - 1)); //
        }
        if (j < board[0].length - 1) {
            neighbors.add(new Coords(i, j + 1));
        }
        return neighbors;
    }

    static class Coords {
        int x;
        int y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Trie {
        TrieNode root;
        Character endSymbol = '*';

        public Trie() {
            this.root = new TrieNode();
        }

        private void add(String word) {
            TrieNode current = root;
            for (Character letter : word.toCharArray()) {
                if (!current.children.containsKey(letter)) {
                    current.children.put(letter, new TrieNode());
                }
                current = current.children.get(letter);
            }
            current.children.put(endSymbol, null);
            current.fullString.put(endSymbol, word);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        Map<Character, String> fullString = new HashMap<Character, String>();
    }
}
