public class GradeMethod {
    public static void main(String[] args) {
        double avg = calculateAverage(85, 78, 92);
        String grade = getGrade(avg);

        System.out.println("Average score: " + avg);
        System.out.println("Grade: " + grade);
    }

    public static double calculateAverage(int javaScore, int englishScore, int mathScore) {
        double avg = (javaScore + englishScore + mathScore) / 3.0;
        return avg;
    }

    public static String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}