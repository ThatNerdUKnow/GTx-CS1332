package Module12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class PatternMatching {
    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     * <p>
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     * <p>
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     * <p>
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return List containing the starting index for each match found.
     */


    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        LinkedList<Integer> occurrences = new LinkedList<>();
        Map<Character, Integer> lastOccurrence = buildLastTable(pattern);
        int i = 0;
        while (i <= text.length() - pattern.length()) {
            int j = pattern.length() - 1;
            while (j >= 0 && comparator.compare(text.charAt(i + j), pattern.charAt(j)) == 0) {
                j--;
                if (j == -1) {
                    occurrences.add(i);
                }
            }
            if (j >= 0) {
                int shift = lastOccurrence.getOrDefault(text.charAt(i + j), -1);
                if (shift < j) {
                    i = i + j - shift;
                } else {
                    i++;
                }
            }
            else{
                i++;
            }

        }
        return occurrences;
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     * <p>
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     * <p>
     * Ex. pattern = octocat
     * <p>
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     * <p>
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     * to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character current = pattern.charAt(i);
            last.put(current, i);
        }
        return last;
    }
}