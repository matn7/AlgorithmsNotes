package whiteboard;

import java.util.*;

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
        Set<String> result = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            Trie curr = trie;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
            }
            curr.word = word;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                explore(board, row, col, trie, visited, result);
            }
        }
        List<String> res = new ArrayList<>(result);
        return res;
    }

    private static void explore(char[][] board, int row, int col, Trie trie, boolean[][] visited, Set<String> result) {
        if (visited[row][col]) {
            return;
        }
        char currElement = board[row][col]; // 's'
        if (!trie.children.containsKey(currElement)) {
            return;
        }
        visited[row][col] = true;
        if (trie.children.get(currElement).word != null) {
            result.add(trie.children.get(currElement).word);
        }

        List<Integer[]> neighbors = getNeighbors(board, row, col);
        for (Integer[] neighbor : neighbors) {
            explore(board, neighbor[0], neighbor[1], trie.children.get(currElement), visited, result);
        }

        visited[row][col] = false;
    }

    public static List<Integer[]> getNeighbors(char[][] board, int row, int col) {
        List<Integer[]> neighbors = new ArrayList<>();
        if (row > 0 && col > 0) { // North - West *
            neighbors.add(new Integer[]{row - 1, col - 1});
        }
        if (row > 0 && col < board[row].length - 1) { // North - East *
            neighbors.add(new Integer[] {row - 1, col + 1});
        }
        if (row < board.length - 1 && col < board[row].length - 1) { // South - East *
            neighbors.add(new Integer[]{row + 1, col + 1});
        }
        if (row > 0) { // North *
            neighbors.add(new Integer[] {row - 1, col});
        }
        if (row < board.length - 1 && col > 0) { // South - West *
            neighbors.add(new Integer[]{row + 1, col - 1});
        }
        if (row < board.length - 1) { // South *
            neighbors.add(new Integer[]{row + 1, col});
        }
        if (col > 0) { // West *
            neighbors.add(new Integer[]{row, col - 1});
        }
        if (col < board[row].length - 1) { // East *
            neighbors.add(new Integer[] {row, col + 1});
        }

        return neighbors;
    }

    static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        String word;
    }

}
