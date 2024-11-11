package november_2024;

import october_2024.CoinChange;

import java.util.*;

public class FindUniqueBinaryString {

    public static void main(String[] args) {
        String[] nums = {"01", "10"};

        FindUniqueBinaryString find = new FindUniqueBinaryString();
        String result = find.findDifferentBinaryString(nums);
        System.out.println(result);

    }

    public String findDifferentBinaryString(String[] nums) {
        Set<String> strSet = new HashSet<>(Arrays.asList(nums));
        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < nums[0].length(); i++) {
            arr.add('0');
        }
        return backtrack(0, arr, strSet);
    }

    private String backtrack(int i, List<Character> curr, Set<String> strSet) {
        if (i == strSet.size()) {
            StringBuilder builder = new StringBuilder();
            for (Character c : curr) {
                builder.append(c);
            }
            return strSet.contains(builder.toString()) ? null : builder.toString();
        }
        String res = backtrack(i + 1, curr, strSet);
        if (res != null) {
            return res;
        }
        curr.set(i, '1');
        res = backtrack(i + 1, curr, strSet);
        return res;
    }


}
