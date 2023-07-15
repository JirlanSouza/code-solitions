package Java2DArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        System.out.println(sumLargestHourglasses(arr));

        bufferedReader.close();
    }

    private static int sumLargestHourglasses(List<List<Integer>> arr) {
        var hourglassesSum = Integer.MIN_VALUE;
        var yLength = arr.size();

        for (int y = 0; y < yLength - 2; y++) {
            var xLength = arr.get(y).size();

            for (int x = 0; x < xLength - 2; x++) {
                hourglassesSum = Math.max(hourglassesSum(x, y, arr), hourglassesSum);
            }
        }

        return hourglassesSum;
    }

    private static int hourglassesSum(int x, int y, List<List<Integer>> arr) {
        return (arr.get(y).get(x) + arr.get(y).get(x + 1) + arr.get(y).get(x + 2)) +
                arr.get(y + 1).get(x + 1) +
                (arr.get(y + 2).get(x) + arr.get(y + 2).get(x + 1) + arr.get(y + 2).get(x + 2));
    }
}
