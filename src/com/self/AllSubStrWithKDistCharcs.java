/*
    Given a string of lowercase alphabets, count all possible substrings that has exactly k distinct characters.
     Example:   Input: abc, k = 2 Output: 2 Possible substrings are {"ab", "bc"}
 */
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AllSubStrWithKDistCharcs {

    public static void main(String[] args) {
        System.out.println(findSubstringsWithKDistinctCharacters("aba",2));
    }

    public static Set<String> findSubstringsWithKDistinctCharacters(String s, int k) {
        Set<String> uniqueSubStrs = new HashSet<>();
        char[] letters = s.toCharArray();
        for (int i = 0, n = letters.length - k; i <= n; i++) {
            Set<Character> uniques = new LinkedHashSet<Character>();
            for (int j = i, m = i + k; j < m; j++) {
                uniques.add(letters[j]);
            }
            if (uniques.size() == k) {
                uniqueSubStrs.add(uniques.stream().map(String::valueOf).collect(Collectors.joining()));
            }
        }
        return uniqueSubStrs;
    }
}
