package april_2025;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";

        PushDominoes pushDominoes = new PushDominoes();
        String result = pushDominoes.pushDominoes(dominoes);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public String pushDominoes(String dominoes) {
        int[] forces = new int[dominoes.length()];
        int maxForce = dominoes.length();
        int force = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            char d = dominoes.charAt(i);
            if (d == 'R') {
                force = maxForce;
            } else if (d == 'L') {
                force = 0;
            } else {
                force = Math.max(0, force - 1);
            }
            forces[i] = force;
        }

        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char d = dominoes.charAt(i);
            if (d == 'L') {
                force = maxForce;
            } else if (d == 'R') {
                force = 0;
            } else {
                force = Math.max(0, force - 1);
            }
            forces[i] -= force;
        }

        StringBuilder builder = new StringBuilder();
        for (int res : forces) {
            if (res == 0) {
                builder.append('.');
            } else if (res > 0) {
                builder.append('R');
            } else {
                builder.append('L');
            }
        }

        return builder.toString();
    }

}
