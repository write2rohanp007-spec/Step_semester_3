package datastructures.assigment_problems;

public class ClassAttendanceTracker {
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int current = 0;
        int longest = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        int[][] samples = {
            {1, 1, 0, 1, 1, 1, 0, 1},
            {0, 0, 0}
        };
        for (int[] days : samples) {
            int[] result = attendanceSummary(days);
            System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
        }
    }
}
