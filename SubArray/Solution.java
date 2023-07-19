package SubArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        var in = new BufferedReader(new InputStreamReader(System.in));

        try {
            int arrayLength = Integer.parseInt(in.readLine());
            int[] array = new int[arrayLength];

            var i = 0;
            for (String number : in.readLine().split(" ")) {
                array[i++] = Integer.parseInt(number);
            }

            in.close();
            System.out.println(countNegativeSubArraySum(array));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int countNegativeSubArraySum(int[] array) {
        int negativeSum = 0;

        for (int i = 0; i < array.length; i++) {
            int subArraySum = array[i];

            if (subArraySum < 0) negativeSum++;

            for (int j = i + 1; j < array.length; j++) {
                subArraySum += array[j];
                if (subArraySum < 0) negativeSum++;
            }
        }

        return negativeSum;
    }
}
