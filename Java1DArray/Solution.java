package Java1DArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        var array = new Integer[n];

        for (int i = 0; i < n; i++) {
            var number = Integer.parseInt(bufferedReader.readLine());
            array[i] = number;
        }

        for (var number: array) {
            System.out.println(number);
        }

        bufferedReader.close();
    }
}
