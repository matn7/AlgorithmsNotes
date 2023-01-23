package coderpro;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = "..R...L..R.";

        PushDominoes pushDominoes = new PushDominoes();
        pushDominoes.pushDominoes(dominoes);

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

        String result = builder.toString();
        return result;
    }

    public String pushDominoes2(String dominoes) {
        int[] rightForces = new int[dominoes.length()];
        int[] leftForces = new int[dominoes.length()];
        int rightForce = dominoes.length();
        for (int i = 0; i < dominoes.length(); i++) {
            char force = dominoes.charAt(i);
            //  .  .  R   .  .  L  .  .  R  .
            // [0, 0, 10, 9, 8, 0, 0, 0, 10, 9]
            //                               *
            if (force == '.') {
                // check previous element
                if (i > 0 && rightForces[i - 1] > 0) {
                    rightForces[i] = rightForces[i - 1] - 1;
                } else {
                    rightForces[i] = 0;
                }
            } else if (force == 'R') {
                rightForces[i] = rightForce;
            } else if (force == 'L') {
                rightForces[i] = 0;
            }
        }

        int leftForce = dominoes.length() * (-1);
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char force = dominoes.charAt(i);
            //  .  .  R   .   .    L  .  .  R  .
            // [0, 0, 0, -8, -9, -10, 0, 0, 0, 0]
            //  *
            if (force == '.') {
                if (i < dominoes.length() - 1 && leftForces[i + 1] < 0) {
                    leftForces[i] = leftForces[i + 1] + 1;
                } else {
                    leftForces[i] = 0;
                }
            } else if (force == 'R') {
                leftForces[i] = 0;
            } else if (force == 'L') {
                leftForces[i] = leftForce;
            }
        }
        int[] resultForces = new int[dominoes.length()];
        for (int i = 0; i < dominoes.length(); i++) {
            int sum = rightForces[i] + leftForces[i];
            resultForces[i] = sum;
        }
        StringBuilder builder = new StringBuilder();
        for (int res : resultForces) {
            if (res == 0) {
                builder.append('.');
            } else if (res > 0) {
                builder.append('R');
            } else {
                builder.append('L');
            }
        }

        String result = builder.toString();
        return result;
    }

}
