
/*
Problem: Greatest Common Divisor of Strings

Approach:
- First check whether both strings are formed using the same repeating pattern.
- If (str1 + str2) is not equal to (str2 + str1), then no common divisor string exists.
- If they are equal, find the GCD of the lengths of both strings.
- The first GCD-length characters of either string will be the largest common divisor string.

Why it works:
- If two strings are made by repeating the same base pattern, then
  str1 + str2 and str2 + str1 will always be identical.
- The largest possible divisor string must have a length that divides
  both string lengths.
- Therefore, we find the GCD of the lengths and return that prefix.

Example:
str1 = "ABABAB"
str2 = "ABAB"

(str1 + str2) = "ABABABABAB"
(str2 + str1) = "ABABABABAB"

Since they are equal:
gcd(6, 4) = 2

First 2 characters = "AB"

Answer = "AB"

Time Complexity: O(n + m)
where n = length of str1 and m = length of str2

Space Complexity: O(n + m)
for the temporary concatenated strings used in comparison
*/
package Arrays_Strings;

public class Greateste_Common_Divisor {
     public String gcdOfStrings(String str1, String str2) {

        // If both strings are not built from the same repeating pattern,
        // then no common divisor string exists.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of the lengths of both strings.
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the prefix of length gcdLength.
        return str1.substring(0, gcdLength);
    }

    // Euclidean Algorithm to find GCD of two numbers.
    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

