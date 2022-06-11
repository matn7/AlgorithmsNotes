package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    private int HOME_TEAM_WON = 1;

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> comp1 = new ArrayList<>(Arrays.asList("HTML", "C#"));
        ArrayList<String> comp2 = new ArrayList<>(Arrays.asList("C#", "Python"));
        ArrayList<String> comp3 = new ArrayList<>(Arrays.asList("Python", "HTML"));
        competitions.add(comp1);
        competitions.add(comp2);
        competitions.add(comp3);
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));

        TournamentWinner tournamentWinner = new TournamentWinner();
        tournamentWinner.tournamentWinner(competitions, results);
    }

    // OK - repeated 05/03/2022
    // rec([
    //      [HTML, C#], [C#, Python], [Python, HTML]
    // ],
    //      [0, 0, 1])
    // O(n) time | O(k) space (k - number of teams in competitions)
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        String currentBestTeam = "";
        Map<String, Integer> scores = new HashMap<>();
        // scores = {"": 0}
        scores.put(currentBestTeam, 0);
        //                                                *
        // competitions = [HTML, C#], [C#, Python], [Python, HTML]
        // results = [0, 0, 1]
        for (int idx = 0; idx < competitions.size(); idx++) {
            ArrayList<String> competition = competitions.get(idx); // [C#, Python]
            int result = results.get(idx); // 1
            String homeTeam = competition.get(0); // Python
            String awayTeam = competition.get(1); // HTML

            String winningTeam = result == HOME_TEAM_WON ? homeTeam : awayTeam; // Python

            // rec(Python, 3, {})
            updateScores(winningTeam, 3, scores);

            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }
        return currentBestTeam;
    }

    // scores = {C#: 3, Python: 6}
    private void updateScores(String team, int point, Map<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + point);
    }
}
