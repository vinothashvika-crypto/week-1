/**
 * Week 1 Assignment 1 - The Exam Hall Seat Duplication Checker
 * Uses only arrays and nested loops (no Collections).
 */
public class A1_ExamHallSeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundAny = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            // Skip a seat number we have already reported
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) continue;

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundAny = true;
                    break;
                }
            }
        }
        if (!foundAny) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    static String toText(int[] values) {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]).append(i < values.length - 1 ? ", " : "");
        }
        return sb.append("}").toString();
    }

    public static void main(String[] args) {
        int[][] halls = {
                {101, 102, 103, 102, 105},
                {101, 102, 103, 104, 105}
        };
        for (int[] hall : halls) {
            System.out.println("Input: " + toText(hall));
            checkDuplicateSeats(hall);
            System.out.println();
        }
    }
}
