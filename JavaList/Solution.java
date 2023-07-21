package JavaList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        var in = new BufferedReader(new InputStreamReader(System.in));

        try (in) {
            List<Integer> list = readList(in);
            Stream<Query> queries = readQueries(in);

            queries.forEach(q -> q.run(list));
            list.forEach(n -> System.out.printf("%d ", n));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        int listLength = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>(listLength);
        String[] strNumbers = reader.readLine().split(" ");

        for (String strNumber : strNumbers) {
            list.add(Integer.parseInt(strNumber));
        }
        return list;
    }

    private static Stream<Query> readQueries(BufferedReader reader) throws IOException {
        int queriesNumber = Integer.parseInt(reader.readLine());

        return Stream.generate(() -> {
            try {
                QueryType type = QueryType.newType(reader.readLine());
                String[] queryItems = reader.readLine().split(" ");
                int index = Integer.parseInt(queryItems[0]);
                int value = -1;

                if (queryItems.length > 1) value = Integer.parseInt(queryItems[1]);

                return new Query(type, index, value);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).limit(queriesNumber);
    }
}

class Query {
    private final QueryType type;
    private final int index;
    private final int value;

    public Query(QueryType type, int index, int value) {
        this.type = type;
        this.index = index;
        this.value = value;
    }

    public void run(List<Integer> list) {
        switch (type) {
            case INSERT -> list.add(index, value);
            case DELETE -> list.remove(index);
        }

    }
}

enum QueryType {
    INSERT {
        public void run(List<Integer> list, int index, int value) {
            list.add(index, value);
        }

    },

    DELETE {
        public void run(List<Integer> list, int index) {
            list.remove(index);
        }


    };

    static QueryType newType(String value) {
        switch (value) {
            case "Insert" -> {
                return QueryType.INSERT;
            }
            case "Delete" -> {
                return QueryType.DELETE;
            }

            default -> throw new RuntimeException("Invalid QueryType value");
        }
    }
}
