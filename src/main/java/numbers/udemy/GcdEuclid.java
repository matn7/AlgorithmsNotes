package numbers.udemy;

public class GcdEuclid {

    public static void main(String[] args) {
        GcdEuclid gcdEuclid = new GcdEuclid();
        System.out.println(gcdEuclid.gcd(8, 20));
        System.out.println(gcdEuclid.gcd(5, 35));
        System.out.println(gcdEuclid.gcd(40, 60));
    }

    // O(log2(a)) time
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
