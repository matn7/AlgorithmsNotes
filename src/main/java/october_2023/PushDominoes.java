package october_2023;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = "..R...L..R.";

        String result = dominoes(dominoes);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static String dominoes(String dominoes) {

        int[] force = new int[dominoes.length()];
        int maxForce = dominoes.length();
        int currForce = 0;

        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i); // .
            if (c == 'R') {
                currForce = maxForce;
            } else if (c == 'L') {
                currForce = 0;
            } else {
                currForce = Math.max(0, currForce - 1);
            }

            force[i] = currForce;
        }

        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char c = dominoes.charAt(i); // .
            if (c == 'R') {
                currForce = 0;
            } else if (c == 'L') {
                currForce = maxForce;
            } else {
                currForce = Math.max(0, currForce - 1);
            }

            force[i] -= currForce;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < force.length; i++) {
            int current = force[i];
            if (current == 0) {
                builder.append('.');
            } else if (current > 0) {
                builder.append('R');
            } else {
                builder.append('L');
            }
        }

        return builder.toString();
    }

}
