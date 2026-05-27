package Arrays_Strings;
/*
Problem: Merge Strings Alternately

Approach:
- Use two pointers i and j to traverse both strings.
- Add one character from word1 and then one from word2.
- Continue until both strings are completely traversed.
- If one string becomes shorter, append remaining characters from the other string.

Explanation:
We iterate through both strings together and build the answer step by step in alternating order.

Time Complexity: O(n + m)
where n = length of word1 and m = length of word2

Space Complexity: O(n + m)
for storing the final merged string
*/

public class Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;

        StringBuilder ans = new StringBuilder();

        while (i < word1.length() || j < word2.length()) {

            if (i < word1.length()) {
                ans.append(word1.charAt(i));
                i++;
            }

            if (j < word2.length()) {
                ans.append(word2.charAt(j));
                j++;
            }
        }

        return ans.toString();
    }
}
