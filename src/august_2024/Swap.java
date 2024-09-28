package august_2024;

public class Swap {

    public static void main(String[] args) {
        int j = 15;
        int i = 10;

        j = j - i; // 5
        i = i + j;
        j = i - j;

        System.out.println(i);
        System.out.println(j);
    }

}
