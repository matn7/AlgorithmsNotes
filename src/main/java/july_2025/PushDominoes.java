package july_2025;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
//        String dominoes = "L";

        PushDominoes pushDominoes = new PushDominoes();
        String result = pushDominoes.pushDominoes(dominoes);
        System.out.println(result);

        // LL.RR.LLRRLL..
        // LL.RR.LLRRLL..
    }

    // Intuition:
    // - array problem
    // - apply force which push dominoes
    //
    // Approach:
    // - force array
    // - L -> R if force L, set to zero, else set to len of arr
    // Complexity:
    // O(n) time | O(n) space
    // Code:

    // force = 14
    // L -> R
    //  .  L   .   R  .  .  .  L  R  .  .  L  .  .
    // [0, 14, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    // if s[i] = L: f[i] = force
    // else if s[i] = R: force = 0;
    // else: f[i] = f[i-1] - 1 check boundary

    public String pushDominoes(String dominoes) {
        int force = 0;
        int[] forces = new int[dominoes.length()];

        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                force = dominoes.length() + 1;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            }
            force = force - 1;
            forces[i] = Math.max(force, 0);
        }
        // [ 0,  0, 0, 13, 12, 11, 10, 0, 13, 12, 11,  0, 0, 0]
        // [12, 13, 0,  0, 10, 11, 12, 13, 0, 11, 12, 13, 0, 0]
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = dominoes.length() + 1;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            }
            force = force - 1;
            int val = Math.max(force, 0);
            forces[i] = forces[i] - val;

        }
        StringBuilder builder = new StringBuilder();
        for (int j : forces) {
            if (j < 0) {
                builder.append("L");
            } else if (j > 0) {
                builder.append("R");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }


    public String pushDominoes2(String dominoes) {
        int force = 0;
        int[] forcesR = new int[dominoes.length()];

        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                force = dominoes.length() + 1;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            }
            force = force - 1;
            forcesR[i] = Math.max(force, 0);
        }
        // [ 0,  0, 0, 13, 12, 11, 10, 0, 13, 12, 11,  0, 0, 0]
        // [12, 13, 0,  0, 10, 11, 12, 13, 0, 11, 12, 13, 0, 0]
        int[] forcesL = new int[dominoes.length()];
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = dominoes.length() + 1;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            }
            force = force - 1;
            forcesL[i] = Math.max(force, 0);
        }
        int[] result = new int[dominoes.length()];
        for (int i = 0; i < dominoes.length(); i++) {
            result[i] = forcesR[i] - forcesL[i];
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] < 0) {
                builder.append("L");
            } else if (result[i] > 0) {
                builder.append("R");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }

}
