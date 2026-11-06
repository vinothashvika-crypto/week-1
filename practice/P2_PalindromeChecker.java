/**
 * Week 1 Practice 2 - Palindrome Checker (3 Approaches) (The QA Text Verification Toolkit)
 */
public class P2_PalindromeChecker {

    // Approach 1: compare characters from both ends moving toward the middle
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: compare first and last characters, then recurse on the inner substring
    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: reverse a character array and compare it with the original
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    static String label(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    static void checkAll(String text) {
        System.out.println("Input: \"" + text + "\"");
        System.out.println("Iterative: " + label(isPalindromeIterative(text))
                + " | Recursive: " + label(isPalindromeRecursive(text))
                + " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
    }

    public static void main(String[] args) {
        checkAll("madam");
        checkAll("hello");
    }
}
