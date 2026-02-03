package january_2026;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";

        PushDominoes pushDominoes = new PushDominoes();
        String result = pushDominoes.pushDominoes(dominoes);
        System.out.println(result);
        // LL.RR.LLRRLL..
        // LL.RR.LLRRLL..
    }

    // O(n) time | O(n) space
    public String pushDominoes(String dominoes) {
        int force = 0;
        int[] result = new int[dominoes.length()];
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                force = dominoes.length();
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = force == 0 ? 0 : force - 1;
            }
            result[i] = force;
        }

        force = 0;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else if (dominoes.charAt(i) == 'L') {
                force = dominoes.length();
            } else {
                force = force == 0 ? 0 : force - 1;
            }
            result[i] -= force;
        }

        StringBuilder builder = new StringBuilder();
        for (int j : result) {
            if (j < 0) {
                builder.append('L');
            } else if (j > 0) {
                builder.append('R');
            } else {
                builder.append('.');
            }
        }

        return builder.toString();
    }

}
