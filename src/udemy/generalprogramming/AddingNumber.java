package udemy.generalprogramming;

import java.util.ArrayList;
import java.util.List;

public class AddingNumber {

    // {1, 2}               {1, 2, 7}
    // {2, 3}                  {4, 4}
    // ------               ---------
    // {3, 5}               {1, 7, 1}

    public static int[] addNumbers(int[] num1, int[] num2) {
        List<Integer> digitList = new ArrayList<>();
        // store the lengths of the two numbers
        int lastIndex1 = num1.length - 1;
        int lastIndex2 = num2.length - 1;

        // the initial carry is 0, when we start the addition from the least significant digit
        int carry = 0;
        int total = 0;
        int digit = 0;
        while (lastIndex1 >= 0 && lastIndex2 >= 0) {
            total = num1[lastIndex1] + num2[lastIndex2] + carry;
            // if the total was 17 then 17 % 10 is 7, this is the digit that will be stored as the result
            digit = total % 10;
            // if the total > 10 then carry will be 1 otherwise 0
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex1--;
            lastIndex2--;
        }

        // if one number is larger with more digits, ensure that those digits are also added to get the sum
        while (lastIndex1 >= 0) {
            total = num1[lastIndex1] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex1--;
        }

        while (lastIndex2 >= 0) {
            total = num2[lastIndex2] + carry;
            digit = total % 10;
            carry = total / 10;

            digitList.add(0, digit);
            lastIndex2--;
        }

        if (carry != 0) {
            digitList.add(0, carry);
        }

        // convert the number stored in a list to an array
        int[] sum = new int[digitList.size()];
        for (int i = 0; i < digitList.size(); i++) {
            sum[i] = digitList.get(i);
        }
        return sum;
    }

}
