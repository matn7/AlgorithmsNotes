package may_2025;

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
//        String[] words = {"oath","pea","eat","rain"};

        char[][] board = {
                {'o','a','b','n'},
                {'o','t','a','e'},
                {'a','h','k','r'},
                {'a','f','l','v'}
        };

        String[] words = {"oa","oaa"};


        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);

    }

    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        populateTrie(words);
        Set<String> result = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                explore(board, row, col, root, builder, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void explore(char[][] board, int row, int col, TrieNode node, StringBuilder builder, Set<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length
                || !node.children.containsKey(board[row][col]) || board[row][col] == '#') {
            return;
        }
        char c = board[row][col];
        builder.append(c);
        node = node.children.get(c);
        if (node.word) {
            result.add(builder.toString());
        }

        board[row][col] = '#';

        explore(board, row + 1, col, node, builder, result);
        explore(board, row - 1, col, node, builder, result);
        explore(board, row, col + 1, node, builder, result);
        explore(board, row, col - 1, node, builder, result);

        builder.deleteCharAt(builder.length() - 1);
        board[row][col] = c;
    }

    private void populateTrie(String[] words) {
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
        boolean word = false;
    }

}
