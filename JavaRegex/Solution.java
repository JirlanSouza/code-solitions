package JavaRegex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    private static final Pattern pattern = Pattern.compile(
            "^((0\\d{0,2}|25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$"
    );
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            hasValidIp(sc.nextLine());
        }
    }

    private static void hasValidIp(String ip) {
        var isValidIpMatcher = pattern.matcher(ip);

        System.out.println(isValidIpMatcher.matches());
    }
}
