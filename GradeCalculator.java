import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Grade Calculator");

        // Input: Take marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] subjectMarks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained (for 100) in subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextInt();
            totalMarks += subjectMarks[i];
        }

        // Calculate Total Marks
        System.out.println("\nTotal Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);

        // Display Results
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Helper method to calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        return grade;
    }
}
