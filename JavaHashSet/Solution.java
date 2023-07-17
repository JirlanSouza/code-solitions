package JavaHashSet;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        var in = new BufferedReader(new InputStreamReader(System.in));

        try (in) {
            var pairsNumber = Integer.parseInt(in.readLine());
            var parsSet = new HashSet<String>();
            while (pairsNumber-- > 0) {
                parsSet.add(in.readLine());
                System.out.println(parsSet.size());
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
