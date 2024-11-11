package october_2024;

import java.util.*;

public class WordSearchII2 {

    public static void main(String[] args) {

    }

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String w : words) {
            root.addWord(w);
        }

        Set<String> res = new HashSet<>();
        Set<String> visit = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                dfs(r, c, root, new StringBuilder(), visit, board, res);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int r, int c, TrieNode node, StringBuilder word, Set<String> visit, char[][] board,
                     Set<String> res) {
        String key = r + ":" + c;
        if (r < 0 || c < 0 || r == board.length || c == board[r].length || visit.contains(key) || !node.children.containsKey(board[r][c])) {
            return;
        }
        visit.add(key);
        node = node.children.get(board[r][c]);
        word.append(board[r][c]);
        if (node.isWord) {
            res.add(word.toString());
        }

        dfs(r - 1, c, node, word, visit, board, res);
        dfs(r + 1, c, node, word, visit, board, res);
        dfs(r, c - 1, node, word, visit, board, res);
        dfs(r, c + 1, node, word, visit, board, res);
        visit.remove(key);
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;

        public void addWord(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }

}
