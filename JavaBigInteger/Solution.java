package JavaBigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var numberA = new BigInteger(in.next());
        var numberB = new BigInteger(in.next());

        System.out.println(numberA.add(numberB));
        System.out.println(numberA.multiply(numberB));

    }
}
