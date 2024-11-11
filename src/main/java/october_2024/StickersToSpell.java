package october_2024;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StickersToSpell {

    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";

        StickersToSpell stickersToSpell = new StickersToSpell();
        int result = stickersToSpell.minStickers(stickers, target);
        System.out.println(result);
    }


    public int minStickers(String[] stickers, String target) {
        List<Map<Character, Integer>> stickCount = new ArrayList<>();

        for (int i = 0; i < stickers.length; i++) {
            stickCount.add(new HashMap<>());
            String s = stickers[i];
            for (char c : s.toCharArray()) {
                Map<Character, Integer> currMap = stickCount.get(i);
                currMap.put(c, currMap.getOrDefault(c, 0) + 1);
            }
        }

        // key = subseq of target : val = min num of stickers
        Map<String, Integer> dp = new HashMap<>();

        int res = dfs(target, new HashMap<>(), dp, stickCount);

        return res != Integer.MAX_VALUE ? res : -1;
    }

    private int dfs(String t, Map<Character, Integer> stick, Map<String, Integer> dp,
                    List<Map<Character, Integer>> stickCount) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }
        int res = !stick.isEmpty() ? 1 : 0;
        StringBuilder remainT = new StringBuilder();
        for (char c : t.toCharArray()) {
            if (stick.containsKey(c) && stick.get(c) > 0) {
                stick.put(c, stick.getOrDefault(c, 0) - 1);
            } else {
                remainT.append(c);
            }
        }
        String string = remainT.toString();
        if (!string.isEmpty()) {
            int used = Integer.MAX_VALUE;
            for (Map<Character, Integer> s : stickCount) {
                if (!s.containsKey(string.charAt(0))) {
                    continue;
                }
                Map<Character, Integer> sCopy = new HashMap<>(s);
                used = Math.min(used, dfs(string, sCopy, dp, stickCount));
            }
            dp.put(string, used);
            if (used != Integer.MAX_VALUE) {
                res += used;
            }
        }
        return res;
    }



}
