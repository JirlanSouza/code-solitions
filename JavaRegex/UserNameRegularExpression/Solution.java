package JavaRegex.UserNameRegularExpression;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z\\d_]{7,29}$");
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var userNamesNumber = Integer.parseInt(sc.nextLine());

        while (userNamesNumber-- > 0) {
            validateUserName(sc.nextLine());
        }
    }

    private static void validateUserName(String userName) {
        var matcher = pattern.matcher(userName);
        System.out.println(matcher.matches() ? "Valid" : "Invalid");
    }
}
