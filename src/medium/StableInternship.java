package medium;

import java.util.*;

public class StableInternship {

    // O(n^2) time | O(n^2) space
    public int[][] stableInternships(int[][] interns, int[][] teams) {
        // Write your code here.
        Map<Integer, Integer> chosenInterns = new HashMap<>();
        Stack<Integer> freeInterns = new Stack<>();
        for (int i = 0; i < interns.length; i++) {
            freeInterns.push(i);
        }
        int[] currentInternChoices = new int[interns.length];

        List<Map<Integer, Integer>> teamsMap = new ArrayList<>();
        for (int[] team : teams) {
            Map<Integer, Integer> rank = new HashMap<>();
            for (int i = 0; i < team.length; i++) {
                rank.put(team[i], i);
            }
            teamsMap.add(rank);
        }

        while (!freeInterns.isEmpty()) {
            Integer internNum = freeInterns.pop();

            int[] intern = interns[internNum];
            int teamPreferences = intern[currentInternChoices[internNum]];
            currentInternChoices[internNum] += 1;

            if (!chosenInterns.containsKey(teamPreferences)) {
                chosenInterns.put(teamPreferences, internNum);
                continue;
            }

            Integer previousIntern = chosenInterns.get(teamPreferences);
            Integer previousInternRank = teamsMap.get(teamPreferences).get(previousIntern);
            Integer currentInternRank = teamsMap.get(teamPreferences).get(internNum);

            if (currentInternRank < previousInternRank) {
                freeInterns.add(previousIntern);
                chosenInterns.put(teamPreferences, internNum);
            } else {
                freeInterns.add(internNum);
            }
        }

        int[][] matches = new int[interns.length][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> chosenIntern : chosenInterns.entrySet()) {
            matches[index] = new int[] {chosenIntern.getValue(), chosenIntern.getKey()};
            index++;
        }

        return matches;
    }

}
