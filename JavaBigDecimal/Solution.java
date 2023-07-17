package JavaBigDecimal;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        var in = new BufferedReader(new InputStreamReader(System.in));

        try (in) {
            var decimalsNumber = Integer.parseInt(in.readLine());
            var decimalsArray = new ArrayList<String>();

            for (int i = 0; i < decimalsNumber; i++) {
                decimalsArray.add(in.readLine());
            }

            decimalsArray.sort((s1, s2) -> new BigDecimal(s2).compareTo(new BigDecimal(s1)));
            decimalsArray.forEach(System.out::println);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
