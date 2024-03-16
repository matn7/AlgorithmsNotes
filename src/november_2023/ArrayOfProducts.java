package november_2023;

public class ArrayOfProducts {

    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2};
        int[] result = arrayOfProducts(array);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];

        int prod = 1;
        for (int i = 0; i < array.length; i++) {
            result[i] = prod;
            prod *= array[i];
        }

        prod = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= prod;
            prod *= array[i];
        }

        return result;
    }

}
