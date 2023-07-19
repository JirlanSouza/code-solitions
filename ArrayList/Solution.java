package ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        var in = new BufferedReader(new InputStreamReader(System.in));

        try {
            ArrayList<ArrayList<Integer>> list = extractNumbersList(in);
            processQuery(in, list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static ArrayList<ArrayList<Integer>> extractNumbersList(BufferedReader in) throws IOException {
        int linesNumber = Integer.parseInt(in.readLine());
        var list = new ArrayList<ArrayList<Integer>>();

        while (linesNumber-- > 0) {
            String[] numbersStr = in.readLine().split(" ");
            int listLength = Integer.parseInt(numbersStr[0]);
            var subList = new ArrayList<Integer>();

            for (int i = 1; i <= listLength; i++) {
                subList.add(Integer.parseInt(numbersStr[i]));
            }

            list.add(subList);
        }

        return list;
    }

    private static void processQuery(BufferedReader in, ArrayList<ArrayList<Integer>> list) throws IOException {
        int queriesNumber = Integer.parseInt(in.readLine());

        while (queriesNumber-- > 0) {
            String[] query = in.readLine().split(" ");

            try {
                List<Integer> result = list.get(Integer.parseInt(query[0]) - 1);
                Integer resultValue = result.get(Integer.parseInt(query[1]) - 1);

                System.out.println(resultValue);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("ERROR!");
            }
        }

    }
}
