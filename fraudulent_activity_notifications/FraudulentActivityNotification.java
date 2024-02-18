package fraudulent_activity_notifications;

import java.util.List;

public class FraudulentActivityNotification {

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int[] counts = new int[210];
        populateCounts(expenditure, counts, d);
        int notices = 0;

        if (expenditure.size() <= d) {
            return notices;
        }

        int[] arrayToExtractMedian = new int[d];
        float median = getMedian(arrayToExtractMedian, counts);

        for (int i = d; i < expenditure.size(); i++) {
            Integer currentExpenditure = expenditure.get(i);

            if (currentExpenditure >= (2 * median)) {
                notices++;
            }

            updateCounts(counts, expenditure.get(i - d), expenditure.get(i));
            median = getMedian(arrayToExtractMedian, counts);
        }

        return notices;
    }

    private static void populateCounts(List<Integer> list, int[] counts, int size) {
        for (int i = 0; i < size; i++) {
            counts[list.get(i)]++;
        }
    }

    private static void updateCounts(int[] counts, Integer remove, Integer add) {
        counts[remove]--;
        counts[add]++;
    }

    private static float getMedian(int[] arrayToExtractMedian, int[] counts) {
        int sortedListToGetMedianIndex = 0;

        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];

            while (count-- > 0) {
                arrayToExtractMedian[sortedListToGetMedianIndex++] = i;

                if (sortedListToGetMedianIndex > arrayToExtractMedian.length / 2) {
                    break;
                }
            }

            if (sortedListToGetMedianIndex > arrayToExtractMedian.length / 2) {
                break;
            }
        }

        boolean isOdd = (arrayToExtractMedian.length % 2) == 1;

        if (isOdd) {
            return arrayToExtractMedian[arrayToExtractMedian.length / 2];
        }

        return (
                arrayToExtractMedian[arrayToExtractMedian.length / 2] +
                        arrayToExtractMedian[(arrayToExtractMedian.length / 2) - 1]
        ) / 2.0F;
    }
}
