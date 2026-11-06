/**
 * Week 1 Practice 4 - First Non-Repeating Character (The Unique Letter Hunt Mini-Game)
 */
public class P4_FirstNonRepeatingCharacter {

    // Returns the first character that appears exactly once, or '\0' if there is none
    static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i) & 0xFF]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i) & 0xFF] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    static void report(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.print("Input: \"" + text + "\" -> ");
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        report("swiss");
        report("aabbcc");
    }
}
