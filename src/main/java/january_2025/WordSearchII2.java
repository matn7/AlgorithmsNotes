package january_2025;

import java.util.*;

public class WordSearchII2 {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchII2 wordSearchII2 = new WordSearchII2();
        List<String> result = wordSearchII2.findWords(board, words);
        System.out.println(result);
    }

    TrieNode root;
    boolean[][] cache;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        cache = new boolean[board.length][board[0].length];
        populateTrie(words);
        Set<String> result = new HashSet<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char w = board[r][c];
                if (root.children.containsKey(w)) {
                    backtrack(board, r, c, root, "", result);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void backtrack(char[][] board, int r, int c, TrieNode cur, String word, Set<String> result) {
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[r].length - 1 || !cur.children.containsKey(board[r][c]) ||
            cache[r][c]) {
            return;
        }
        char w = board[r][c];
        cache[r][c] = true;
        cur = cur.children.get(w);
        word += w;
        if (cur.word) {
            result.add(word);
        }
        backtrack(board, r + 1, c, cur, word, result);
        backtrack(board, r - 1, c, cur, word, result);
        backtrack(board, r, c + 1, cur, word, result);
        backtrack(board, r, c - 1, cur, word, result);
        cache[r][c] = false;
    }

    private void populateTrie(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.word = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;
    }

}
