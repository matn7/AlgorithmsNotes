package december_2024;

import java.util.*;

public class WordSearchII2 {

    private Set<String> res;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        int ROWS = board.length;
        int COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visit[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.isWord) {
            res.add(word);
        }

        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;
    }


}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        TrieNode curr = this;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
}