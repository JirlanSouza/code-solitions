package StringTokens;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        proccessToken(text);
    }

    private static void proccessToken(String text) {
        //Pattern pattern = Pattern.compile("[A-Za-z !,?._'@]+");
        var tokens = text.split("[^A-Za-z]");
        System.out.println(tokens);

        for (String token: tokens) {
            System.out.println(token);
        }
    }
}
