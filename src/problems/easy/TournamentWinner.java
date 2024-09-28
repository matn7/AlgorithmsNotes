package problems.easy;

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

    // O(n) time | O(k) space (k - number of teams in competitions)
    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        String currentBestTeam = "";
        Map<String, Integer> scores = new HashMap<>();
        scores.put(currentBestTeam, 0);
        for (int idx = 0; idx < competitions.size(); idx++) {
            ArrayList<String> competition = competitions.get(idx);
            int result = results.get(idx);
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winningTeam = result == HOME_TEAM_WON ? homeTeam : awayTeam;

            updateScores(winningTeam, 3, scores);

            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }
        return currentBestTeam;
    }

    private void updateScores(String team, int point, Map<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + point);
    }
}
