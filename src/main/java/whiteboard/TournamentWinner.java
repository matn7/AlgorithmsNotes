package whiteboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    // O(n) time | O(k) space (k is number of teams)
    // #1: 09/07/2022
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        Map<String, Integer> winnersMap = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            int winnerIndex = results.get(i) == 0 ? 1 : 0;
            String winnerTeam = competition.get(winnerIndex);
            if (winnersMap.containsKey(winnerTeam)) {
                winnersMap.put(winnerTeam, winnersMap.get(winnerTeam) + 3);
            } else {
                winnersMap.put(winnerTeam, 3);
            }
        }

        String winner = "";
        int maxPoints = 0;
        for (Map.Entry<String, Integer> entry : winnersMap.entrySet()) {
            if (entry.getValue() > maxPoints) {
                maxPoints = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }

}
