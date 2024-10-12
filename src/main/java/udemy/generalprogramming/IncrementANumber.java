package udemy.generalprogramming;

import java.util.ArrayList;
import java.util.List;

public class IncrementANumber {

    // ABB ---> ABC
    // ABBC ---> ABBD
    // ABCD ---> ABDA

    private static List<Character> digitList = new ArrayList<>();

    static {
        digitList.add('A');
        digitList.add('B');
        digitList.add('C');
        digitList.add('D');
    }

    public static void main(String[] args) {
        List<Character> originalNumber = new ArrayList<>();
        originalNumber.add('A');
        originalNumber.add('B');
        originalNumber.add('C');
        originalNumber.add('D');
        originalNumber.add('D');

        increment(originalNumber);
    }

    public static List<Character> increment(List<Character> originalNumber) {
        // use characters to represent the number
        List<Character> incrementedNumber = new ArrayList<>();

        boolean incrementComplete = false;
        // start with the least significant digit which is the last character in the list
        int currentIndex = originalNumber.size() - 1;
        incrementedNumber.addAll(originalNumber);

        while (!incrementComplete && currentIndex >= 0) {
            // we go through the number digit by digit till we get to the most significant digit at index 0 of the list
            char currentDigit = originalNumber.get(currentIndex);
            // get the position of the least significant digit in the digit list which has the numbers in ascending order
            int indexOfCurrentDigit = digitList.indexOf(currentDigit);

            // get the next digit on increment, this will wrap around to the first digit which is why we use the modulo operator
            int indexOfNextDigit = (indexOfCurrentDigit + 1) % digitList.size();

            // update the current digit to be the incremented value
            incrementedNumber.remove(currentIndex);
            incrementedNumber.add(currentIndex, digitList.get(indexOfNextDigit));

            // if the next digit did not wrap around we're done!
            // we can exit the loop, otherwise continue incrementing the next most significant digit
            if (indexOfNextDigit != 0) {
                incrementComplete = true;
            }

            // if we're at the most significant digit and that wrapped around we add a new digit to the incremented number
            // like going from 9 -> 10
            if (currentDigit == 0 && indexOfNextDigit == 0) {
                incrementedNumber.add(0, digitList.get(0));
            }

            currentIndex--;
        }

        return incrementedNumber;
    }

}
