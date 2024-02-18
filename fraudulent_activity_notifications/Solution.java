package fraudulent_activity_notifications;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("fraudulent_activity_notifications", "big_data.txt");
        BufferedReader bufferedReader = Files.newBufferedReader(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new StringWriter());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long time = System.nanoTime();
        int result = FraudulentActivityNotification.activityNotifications(expenditure, d);

        System.out.println(Duration.of(System.nanoTime() - time, ChronoUnit.NANOS));

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        System.out.println(result);

        bufferedReader.close();
        bufferedWriter.close();
    }
}

