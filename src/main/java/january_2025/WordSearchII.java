package january_2025;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);

    }

    Set<String> res;
    boolean[][] visit;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }
        res = new HashSet<>();
        visit = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                dfs(r, c, board, root, "");
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(int r, int c, char[][] board, TrieNode node, String word) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length || visit[r][c] ||
                !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;
        char w = board[r][c];
        word += w;
        node = node.children.get(w);

        if (node.isWord) {
            res.add(word);
        }

        dfs(r - 1, c, board, node, word);
        dfs(r + 1, c, board, node, word);
        dfs(r, c - 1, board, node, word);
        dfs(r, c + 1, board, node, word);

        visit[r][c] = false;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }

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