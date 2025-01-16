package december_2024;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
        // board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
        // ["o","a","b","n"],["o","t","a","e"],["a","h","k","r"],["a","f","l","v"]]
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };

//        String[] words = {"oath","pea","eat","rain"};

        char[][] board = {
                {'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}
        };
        String[] words = {"oa","oaa"};

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        generateTries(words);
        Set<String> result = new HashSet<>();
        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs(r, c, board, root.children.get(board[r][c]), result, seen);
                }
            }
        }

        return result.stream().toList();
    }

    private void dfs(int r, int c, char[][] board, TrieNode root, Set<String> result, boolean[][] seen) {
        if (seen[r][c]) {
            return;
        }
        seen[r][c] = true;
        if (root.word) {
            result.add(root.fullWord);
//            return;
        }
        TrieNode curr = root;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];

            if (isValidPos(newRow, newCol, board)) {
                char character = board[newRow][newCol];
                if (curr.children.containsKey(character) && !seen[newRow][newCol]) {
                    seen[newRow][newCol] = true;
                    for (Map.Entry<Character, TrieNode> element : curr.children.entrySet()) {
                        TrieNode value = element.getValue();
                        dfs(newRow, newCol, board, value, result, seen);
                    }
                    seen[newRow][newCol] = false;
                }
            }
        }
        seen[r][c] = false;
    }

    private boolean isValidPos(int row, int col, char[][] board) {
        return row >= 0 && row <= board.length - 1 && col >= 0 && col <= board[row].length - 1;
    }

    private void generateTries(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.word = true;
            curr.fullWord = word;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word;
        String fullWord;
    }

}
