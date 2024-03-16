package october_2023;

public class MajorityElement {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 1, 2};

        majorityElement(array);
    }

    // O(n) time | O(1) space
    public static int majorityElement(int[] array) {
        // [1, 2, 3, 2, 2, 1, 2]
        //                    *
        int count = 1; // 2
        int curr = array[0]; // 2

        for (int i = 1; i < array.length; i++) {
            int other = array[i]; // 1
            if (other == curr) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                curr = other;
                count = 1;
            }
        }

        return curr;
    }

}
