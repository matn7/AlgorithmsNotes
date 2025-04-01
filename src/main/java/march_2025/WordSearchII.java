package march_2025;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    Set<String> res;
    boolean[][] visit;
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        root = new TrieNode();
        createTree(words);
        visit = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                backtrack(board, r, c, "", root);
            }
        }
        return new ArrayList<>(res);
    }

    private void backtrack(char[][] board, int r, int c, String word, TrieNode node) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length ||
            visit[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;
        char w = board[r][c];
        word += w;
        node = node.children.get(w);

        if (node.word) {
            res.add(word);
        }

        backtrack(board, r + 1, c, word, node);
        backtrack(board, r - 1, c, word, node);
        backtrack(board, r, c + 1, word, node);
        backtrack(board, r, c - 1, word, node);

        visit[r][c] = false;
    }

    private void createTree(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.word = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word;
    }

}
