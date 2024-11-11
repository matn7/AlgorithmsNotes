package october_2024;

import java.util.*;

public class WordSearchII {

    public static void main(String[] args) {
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//
//        String[] words = {"oath", "pea", "eat", "rain"};

//        char[][] board = {
//                {'a'}
//        };
//
//        String[] words = {"a"};

//        char[][] board = {
//                {'o', 'a', 'b', 'n'},
//                {'o', 't', 'a', 'e'},
//                {'a', 'h', 'k', 'r'},
//                {'a', 'f', 'l', 'v'}
//        };
//
//        String[] words = {"oa", "oaa"};

//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//
////        String[] words = {"oath", "pea", "eat", "rain", "hklf", "hf"};
//        String[] words = {"hklf", "hf"};

        char[][] board = {
                {'a', 'a'}
        };
        String[] words = {"aaa"};

        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        initTrie(words);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                TrieNode curr = root;
                char c = board[row][col];
                if (curr.children.containsKey(c)) {
                    // explore
                    curr = curr.children.get(c);
                    Set<String> seen = new HashSet<>();
                    dfs(row, col, board, result, curr, seen);
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, char[][] board, List<String> result, TrieNode node, Set<String> seen) {
        String key = getKey(row, col);
        if (seen.contains(key)) return; // Return if already visited
        if (node.word && !result.contains(node.fullStr)) {
            result.add(node.fullStr);
            return;
        }

        seen.add(key); // Mark as visited

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPos(newRow, newCol, board)) {
                char nextChar = board[newRow][newCol];
                TrieNode childNode = node.children.get(nextChar); // Get the child node directly
                if (childNode != null) {
                    dfs(newRow, newCol, board, result, childNode, seen); // Recur with child node
                }
            }
        }

        seen.remove(key); // Unmark the cell after exploring all paths
    }

    private String getKey(int row, int col) {
        return row + ":" + col;
    }

    private boolean isValidPos(int row, int col, char[][] board) {
        return row >= 0 && row <= board.length - 1 && col >= 0 && col <= board[row].length - 1;
    }

    private void initTrie(String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.fullStr = word;
            curr.word = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String fullStr;
        boolean word;
    }

}
