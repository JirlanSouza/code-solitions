package String.TagContentExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");

    public static void main(String[] args) {
        var in = new BufferedReader(new InputStreamReader(System.in));

        try (in) {
            var linesNumber = Integer.parseInt(in.readLine());

            while (linesNumber-- > 0) {
                var inputLine = in.readLine();
                System.out.print(extractContent(inputLine));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String extractContent(String inputLine) {
        Matcher matcher = pattern.matcher(inputLine);
        var builder = new StringBuilder();

        while (matcher.find()) {
            builder.append(matcher.group(2));
            builder.append("\n");
        }

        return builder.length() > 0 ? builder.toString() : "None\n";
    }
}
