package numbers.udemy;

public class ExtendedEuclideans {

    // Ax  + By      = GCD(A,B)             GCD(A,B) = GCD(B,A%B)
    // Bx1 + (A%B)y1 = GCD(B,A%B)           A%B = A - floor(A/B) * B

    public static void main(String[] args) {
        ExtendedEuclideans extendedEuclideans = new ExtendedEuclideans();
        int[] result = extendedEuclideans.extendedGCD(18, 12);
        System.out.println(result[2]);
        System.out.println(extendedEuclideans.gcd(18, 12));
    }

    // Euclid's Algorithm
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Extended Euclid's Algorithm ax + by = gcd(a,b)
    public int[] extendedGCD(int a, int b) {

        if (b == 0) {
            // return the values of x and y
            return new int[] {1, 0, a};
        }
        int[] result = extendedGCD(b, a%b);

        // After recursive call is over
        int smallX = result[0];
        int smallY = result[1];
        int gcd = result[2];

        int x = smallY;
        int y = smallX - (a/b) * smallY;
        return new int[] {x, y, gcd};
    }

}
