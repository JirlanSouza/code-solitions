package JavaMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            Map<String, String> phonesNumberBook = readPhoneNumbers(in);
            var queries = in.lines();

            queries.forEach(q -> {

                if (!phonesNumberBook.containsKey(q)) {
                    System.out.println("Not found");
                    return;
                }

                System.out.printf("%s=%s\n", q, phonesNumberBook.get(q));

            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Map<String, String> readPhoneNumbers(BufferedReader reader) throws IOException {
        int phonesNumbersQuantity = Integer.parseInt(reader.readLine());
        var phoneNumberBook = new HashMap<String, String>(phonesNumbersQuantity);

        while (phonesNumbersQuantity-- > 0) {
            String name = reader.readLine();
            String phoneNumber = reader.readLine();

            phoneNumberBook.put(name, phoneNumber);
        }

        return phoneNumberBook;
    }
}
