package december_2023;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = "..R...L..R.";
        String result = pushDominoes(dominoes);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static String pushDominoes(String dominoes) {
        int[] forces = new int[dominoes.length()];
        int maxForce = dominoes.length();

        // . .  R  . . . L . . R .
        // 0 0 11 10
        int currForce = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            char curr = dominoes.charAt(i);
            if (curr == 'R') {
                currForce = maxForce;
            } else if (curr == 'L') {
                currForce = 0;
            } else {
                currForce = Math.max(0, currForce - 1);
            }
            forces[i] = currForce;
        }
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char curr = dominoes.charAt(i);
            if (curr == 'L') {
                currForce = maxForce;
            } else if (curr == 'R') {
                currForce = 0;
            } else {
                currForce = Math.max(0, currForce - 1);
            }
            forces[i] -= currForce;
        }

        StringBuilder builder = new StringBuilder();
        for (int num : forces) {
            if (num > 0) {
                builder.append('R');
            } else if (num < 0) {
                builder.append('L');
            } else {
                builder.append('.');
            }
        }

        return builder.toString();

    }

}
