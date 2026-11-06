/**
 * Week 1 Practice 3 - BMI Calculator for a Team (The Corporate Wellness Program)
 */
public class P3_BmiCalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    static double calculateBmi(double heightMeters, double weightKg) {
        return weightKg / (heightMeters * heightMeters);
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-7s | %-10s | %-11s | %-6s | %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------+------------+-------------+--------+------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            System.out.printf("%-7d | %-10.2f | %-11.1f | %-6.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        // Team of 10 people (first two match the sample in the problem sheet)
        double[] heights = {1.75, 1.60, 1.68, 1.82, 1.55, 1.70, 1.65, 1.78, 1.90, 1.62};
        double[] weights = {70, 90, 52, 85, 45, 68, 77, 95, 80, 58};
        printWellnessReport(heights, weights);
    }
}
