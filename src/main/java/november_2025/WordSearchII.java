package november_2025;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);

    }

    // O(R * C * L) time | O(R * C + S) space
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        Set<String> result = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                dfs(board, r, c, trie.root, builder, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c, TrieNode curr, StringBuilder builder, Set<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] == '#'
                || curr.children[board[r][c] - 'a'] == null) {
            return;
        }
        char ch = board[r][c];
        board[r][c] = '#';
        builder.append(ch);
        int idx = ch - 'a';
        curr = curr.children[idx];
        if (curr.word) {
            result.add(builder.toString());
        }
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : directions) {
            dfs(board, r + dir[0], c + dir[1], curr, builder, result);
        }
        builder.deleteCharAt(builder.length() - 1);
        board[r][c] = ch;
    }


    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) {
                    curr.children[i] = new TrieNode();
                }
                curr = curr.children[i];
            }
            curr.word = true;
        }

    }

    static class TrieNode {
//        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode[] children = new TrieNode[26];
        boolean word;
    }

}


