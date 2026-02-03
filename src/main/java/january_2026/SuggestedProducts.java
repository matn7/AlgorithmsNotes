package january_2026;

import java.util.*;

public class SuggestedProducts {

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        SuggestedProducts suggestedProducts = new SuggestedProducts();
        List<List<String>> lists = suggestedProducts.suggestedProducts(products, searchWord);
        System.out.println(lists);


        //
        // [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
    }


    private TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        populateTrie(products);

        TrieNode curr = root;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            if (curr == null || !curr.children.containsKey(c)) {
                result.add(new ArrayList<>());
                curr = null;
                continue;
            }

            curr = curr.children.get(c);

            List<String> found = new ArrayList<>();
            StringBuilder builder = new StringBuilder(searchWord.substring(0, i + 1));

            dfs(curr, builder, found);

            result.add(found);
        }

        return result;
    }

    private void dfs(TrieNode node, StringBuilder builder, List<String> found) {
        if (found.size() == 3) return;

        if (node.word) {
            found.add(builder.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            if (found.size() == 3) return;

            builder.append(entry.getKey());
            dfs(entry.getValue(), builder, found);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private void populateTrie(String[] products) {
        for (String product : products) {
            TrieNode curr = root;
            for (char c : product.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.word = true;
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<>();
        boolean word = false;
    }
}
