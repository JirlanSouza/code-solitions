package StringIntroduction;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var textA = sc.nextLine();
        var textB = sc.nextLine();
        processStrings(textA, textB);
    }

    private static void processStrings(String a, String b) {
        System.out.println(a.length() + b.length());
        var isGreeter = (a.charAt(0) > b.charAt(0)) ? "Yes" : "No";

        var capitalizedA = a.substring(0, 1).toUpperCase() + a.substring(1);
        var capitalizedB = b.substring(0, 1).toUpperCase() + b.substring(1);

        System.out.println(isGreeter);
        System.out.printf("%s %s\n",capitalizedA, capitalizedB);
    }
}
