/**
 * Week 1 Assignment 5 - The Movie Review Word Length Profiler
 */
public class A5_MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        int shortCount = 0, mediumCount = 0, longCount = 0;
        String[] words = review.trim().split("\\s+");
        for (String word : words) {
            // Count letters only, so punctuation like "great!" is not counted
            int letters = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) letters++;
            }
            if (letters == 0) continue;
            if (letters <= 4) shortCount++;
            else if (letters <= 8) mediumCount++;
            else longCount++;
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.println("Review: \"" + review + "\"");
        classifyWordLengths(review);
    }
}
