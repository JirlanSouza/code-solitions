package array_manipulation;

import java.util.List;

class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        var resultArray = new long[n + 1];
        var maxValue = Long.MIN_VALUE;

        for (List<Integer> query : queries) {
            int startIndex = query.get(0);
            int endIndex = query.get(1);
            int value = query.get(2);

            resultArray[startIndex - 1] += value;
            resultArray[endIndex] -= value;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += resultArray[i];
            maxValue = Math.max(maxValue, sum);
        }

        return maxValue;
    }
}


