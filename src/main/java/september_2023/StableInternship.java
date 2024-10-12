package september_2023;

import java.util.*;

public class StableInternship {

    public static void main(String[] args) {
        int[][] interns = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 2, 0}
        };

        int[][] teams = {
                {2, 1, 0},
                {0, 1, 2},
                {0, 1, 2}
        };

        StableInternship stableInternship = new StableInternship();
        stableInternship.stableInternships(interns, teams);
    }

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
                int internNum = team[i];
                rank.put(internNum, i);
            }
            teamsMap.add(rank);
        }

        while (!freeInterns.isEmpty()) {
            Integer internNum = freeInterns.pop();

            int[] intern = interns[internNum];
            int teamPreference = intern[currentInternChoices[internNum]];
            currentInternChoices[internNum] += 1;

            if (!chosenInterns.containsKey(teamPreference)) {
                chosenInterns.put(teamPreference, internNum);
                continue;
            }

            Integer previousIntern = chosenInterns.get(teamPreference);
            Integer previousInternRank = teamsMap.get(teamPreference).get(previousIntern);
            Integer currentInternRank = teamsMap.get(teamPreference).get(internNum);

            if (currentInternRank < previousInternRank) {
                freeInterns.push(previousIntern);
                chosenInterns.put(teamPreference, internNum);
            } else {
                freeInterns.push(internNum);
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
