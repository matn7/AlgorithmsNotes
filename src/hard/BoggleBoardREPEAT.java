package hard;

import java.util.*;

public class BoggleBoardREPEAT {

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

        List<String> result = boggleBoard(board, words);

        for (String element : result) {
            System.out.print(element + ", ");
        }

    }

    // O(w*s + n*m * 8^s) time | O(w*s + n*m) space (s longest string, w number of words)
    // OK - repeated 25/01/2022
    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        // {
        //      "t":{
        //              "h":{"i":{"s":{"*":{TRUE}}}},
        //              "e":{"s":{"t":{"*":{TRUE}}}}
        //      },
        //      "i":{"s":{"*":{TRUE}}},
        //      "n":{"o":{"t":{"*":{TRUE}}}},
        //      "a":{"*":{TRUE}},
        //      "s":{"i":{"m":{"p":{"l":{"e":{"*":{TRUE}}}}}}},
        //      "b":{"o":{
        //                  "g":{"g":{"l":{"e":{"*":{TRUE}}}}},
        //                  "a":{"r":{"d":{"*":{TRUE}}}}
        //      }},
        //      "R":{"E":{"P":{"E":{"A":{"T":{"E":{"D":{"*":{TRUE}}}}}}}}},
        //      "N":{"O":{"T":{"R":{"E":{"-":{"P":{"E":{"A":{"T":{"E":{"D":{"*":{TRUE}}}}}}}}}}}}}
        // }
        Map<String, Boolean> finalWords = new HashMap<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                explore(i, j, board, trie.root, visited, finalWords);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Boolean> element : finalWords.entrySet()) {
            result.add(element.getKey());
        }

        return result;
    }

    private static void explore(int i, int j, char[][] board, TrieNode trieNode, boolean[][] visited,
                                Map<String, Boolean> finalWords) {
        if (visited[i][j]) {
            return;
        }

        char letter = board[i][j]; // 't' | 'i' | 's' | 'h'
        if (!trieNode.children.containsKey(letter)) {
            return;
        }
        visited[i][j] = true;
        trieNode = trieNode.children.get(letter); // "*"
        if (trieNode.children.containsKey('*')) {
            finalWords.put(trieNode.fullString.get('*'), Boolean.TRUE); // this
        }
        List<Coords> neighbors = getNeighbors(i, j, board);
        // t: 'i', 's', 'h'
        // h: 'm', 's', 'i', 't', 'i'
        // i: 't', 'i', 'x', 'b', 'h', 'x', 's', 'm'
        // i: 'p', 'i', 'm', 'h', 's'
        for (Coords neighbor : neighbors) { // 'm'
            explore(neighbor.x, neighbor.y, board, trieNode, visited, finalWords);
        }
        visited[i][j] = false;
    }

    private static List<Coords> getNeighbors(int i, int j, char[][] board) {
        List<Coords> neighbors = new ArrayList<>();
        if (i > 0 && j > 0) {
            neighbors.add(new Coords(i - 1, j - 1)); // NORTH-WEST
        }
        if (i > 0 && j < board[0].length - 1) { // NORTH-EAST
            neighbors.add(new Coords(i - 1, j + 1));
        }
        if (i < board.length - 1 && j < board[0].length - 1) { // SOUTH-EAST
            neighbors.add(new Coords(i + 1, j + 1)); // 'i'
        }
        if (i < board.length - 1 && j > 0) { // SOUTH-WEST
            neighbors.add(new Coords(i + 1, j - 1));
        }
        if (i > 0) { // NORTH
            neighbors.add(new Coords(i - 1, j));
        }
        if (i < board.length - 1) { // SOUTH
            neighbors.add(new Coords(i + 1, j)); // 's'
        }
        if (j > 0) { // WEST
            neighbors.add(new Coords(i, j - 1));
        }
        if (j < board[0].length - 1) { // EAST
            neighbors.add(new Coords(i, j + 1)); // 'h'
        }
        return neighbors; // 'i', 's', 'h'
        // 'm', 's', 'i', 't', 'i'
        // 't', 'i', 'x', 'b', 'h', 'x', 's', 'm'
        // 'p', 'i', 'm', 'h', 's'
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
            current.children.put('*', null);
            current.fullString.put('*', word);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        Map<Character, String> fullString = new HashMap<Character, String>();
    }

}

