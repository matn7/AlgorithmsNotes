package hard;

public class IndexEqualsValue {

    public static void main(String[] args) {
        int[] array = {-5, -3, 0, 3, 4, 5, 9};

        IndexEqualsValue index = new IndexEqualsValue();
        int i = index.indexEqualsValue(array);

        System.out.println(i);
    }

    public int indexEqualsValue(int[] array) {
        // Write your code here.
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (counter == array[i]) {
                return i;
            }
            counter++;
        }
        return -1;
    }

}
