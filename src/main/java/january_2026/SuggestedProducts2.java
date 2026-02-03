package january_2026;

import java.util.*;

public class SuggestedProducts2 {

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        SuggestedProducts2 suggestedProducts = new SuggestedProducts2();
        List<List<String>> lists = suggestedProducts.suggestedProducts(products, searchWord);
        System.out.println(lists);


        //
        // [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
    }

    // O(nlog(n)) time | O(n) space
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();

        int left = 0;

        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);

            left = lowerBound(products, prefix, left);
            List<String> suggestions = new ArrayList<>();

            for (int j = left; j < Math.min(left + 3, products.length); j++) {
                if (products[j].startsWith(prefix)) {
                    suggestions.add(products[j]);
                } else {
                    break;
                }
            }

            result.add(suggestions);
        }

        return result;
    }

    private int lowerBound(String[] arr, String target, int start) {
        int left = start, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
