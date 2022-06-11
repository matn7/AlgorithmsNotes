package medium;

import java.util.*;

public class BoggleBoard {

    public static void main(String[] args) {

//        char[][] board = {
//                {'t', 'h', 'i', 's', 'i', 's', 'a'},
//                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
//                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
//                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
//                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
//                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
//                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
//                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
//                {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
//        };
//
//        String[] words = {"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};

        char[][] board = {
                {'y', 'g', 'f', 'y', 'e', 'i'},
                {'c', 'o', 'r', 'p', 'o', 'u'},
                {'j', 'u', 'z', 's', 'e', 'l'},
                {'s', 'y', 'u', 'r', 'h', 'p'},
                {'e', 'a', 'e', 'g', 'n', 'd'},
                {'h', 'e', 'l', 's', 'a', 't'}
        };

        String[] words = {"san", "sana", "at", "vomit", "yours", "help", "end", "been", "bed",
                "danger", "calm", "ok", "chaos", "complete", "rear", "going", "storm", "face", "epual", "dangerous"};

        boggleBoard(board, words);

    }

    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        Map<String, Node> nodeMap = new TreeMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                String key = row + "-" + col;
                if (nodeMap.containsKey(key)) {
                    Node node = nodeMap.get(key);
                    addNeighbors(board, nodeMap, row, col, node);
                } else {
                    Node element = new Node(board[row][col]);
                    nodeMap.put(key, element);
                    // add neighbors
                    addNeighbors(board, nodeMap, row, col, element);
                }
            }
        }

        List<String> wordsArray = new ArrayList<>();
        Map<String, Boolean> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsArray.add(word);
            wordsMap.put(word, Boolean.FALSE);
        }

        Collection<Node> nodes = nodeMap.values();

        List<String> result = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        for (Node element : nodes) {
            if (!element.isVisited()) {
//                element.setVisited(true);
//                builder.append(element.value);
                depthFirst(element, builder, wordsArray, result, wordsMap);
            }
            builder.setLength(0);
        }
//
        builder.setLength(0);
        for (Node element : nodes) {
            if (!element.isVisited()) {
                System.out.println("***");
            }
        }

        return result;
    }

    private static void depthFirst(Node node, StringBuilder builder, List<String> wordsArray,
                                   List<String> result, Map<String, Boolean> wordsMap) {
//        System.out.println(node.value);

        boolean arrayChanged = false;

        node.setVisited(true);
        builder.append(node.value);

        for (String word : wordsArray) {
            if (word.equals(builder.toString())) {
                result.add(builder.toString());
                arrayChanged = true;
            }
        }

        if (arrayChanged) {
            wordsArray.remove(builder.toString());
            builder.setLength(0);
        }

        Set<String> checkWords = new HashSet<>();
        for (String element : wordsArray) {
            if (element.startsWith(builder.toString())) {
                checkWords.add(element);
            }
        }

        Set<Node> neighbors = node.getNeighbors();
        for (Node element : neighbors) {
//            if (!element.isVisited()) {
                builder.append(element.value);
                Set<String> innerCheckWords = new HashSet<>();
                for (String word : checkWords) {
                    if (word.startsWith(builder.toString())) {
                        innerCheckWords.add(word);
                    }
                }
                if (innerCheckWords.size() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
//                    node.setVisited(true);
//                    builder.append(element.value);
                    depthFirst(element, builder, wordsArray, result, wordsMap);
                } else {
                    // means substring does not match
                    builder.deleteCharAt(builder.length() - 1);
                }
//            }
        }
    }

    private static void addNeighbors(char[][] board, Map<String, Node> nodeMap, int row, int col, Node element) {
        // North
        if (row - 1 >= 0) {
            String key1 = (row - 1) + "-" + col;
            if (nodeMap.containsKey(key1)) {
                // update neighbors
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row - 1][col]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
        // South
        if (row + 1 < board.length) {
            String key1 = (row + 1) + "-" + col;
            if (nodeMap.containsKey(key1)) {
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row + 1][col]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
        // West
        if (col - 1 >= 0) {
            String key1 = row + "-" + (col - 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row][col - 1]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
        // South
        if (col + 1 < board[row].length) {
            String key1 = row + "-" + (col + 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row][col + 1]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
        // North - West
        if (row - 1 >= 0 && col - 1 >= 0) {
            String key1 = (row - 1) + "-" + (col - 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row - 1][col - 1]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
        // North - East
        if (row - 1 >= 0 && col + 1 < board[row].length) {
            String key1 = (row - 1) + "-" + (col + 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row - 1][col + 1]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
        // South - East
        if (row + 1 < board.length && col + 1 < board[row].length) {
            String key1 = (row + 1) + "-" + (col + 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row + 1][col + 1]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
        // South - West
        if (row + 1 < board.length && col - 1 >= 0) {
            String key1 = (row + 1) + "-" + (col - 1);
            if (nodeMap.containsKey(key1)) {
                element.addNeighbors(nodeMap.get(key1));
                nodeMap.get(key1).addNeighbors(element);
            } else {
                Node newNode = new Node(board[row + 1][col - 1]);
                element.addNeighbors(newNode);
                nodeMap.put(key1, newNode);
            }
        }
    }

    enum Direction {
        NORTH, SOUTH, WEST, EAST
    }

    static class Node {
        char value;
        Set<Node> neighbors;
        boolean visited;

        public Node(char value) {
            this.value = value;
            this.neighbors = new HashSet<>();
            this.visited = false;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public Set<Node> getNeighbors() {
            return neighbors;
        }

        public void addNeighbors(Node node) {
            this.neighbors.add(node);
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

}
