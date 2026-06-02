package Arrays_Strings;

/*
Problem: Reverse Words in a String

Approach:
- Remove leading and trailing spaces using trim().
- Split the string into words using "\\s+":
    - "\\s+" matches one or more whitespace characters.
    - This automatically handles multiple spaces between words.
- Reverse the array of words using the two-pointer technique.
- Join the words back together with a single space.

Why it works:
- Splitting separates all words into an array.
- Reversing the array places the words in reverse order.
- Joining the array reconstructs the final string with exactly one space
  between each word.

Example:
s = "  the sky   is blue  "

After trim and split:

["the", "sky", "is", "blue"]

After reversing:

["blue", "is", "sky", "the"]

After joining:

"blue is sky the"

Answer = "blue is sky the"

Time Complexity: O(n)
- Splitting the string takes O(n).
- Reversing the words takes O(n).
- Joining the words takes O(n).

Space Complexity: O(n)
- Extra space is used to store the array of words.
*/

public class Reverse_Words_In_A_String {

    public String reverseWords(String s) {

        // Remove extra spaces and split the string into words.
        String[] arr = s.trim().split("\\s+");

        // Two pointers for reversing the array.
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {

            // Swap words at both ends.
            String temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // Move pointers inward.
            l++;
            r--;
        }

        // Join all words with a single space.
        return String.join(" ", arr);
    }
}

/*
Key Insight

We do NOT reverse the characters inside each word.

We only reverse the ORDER of the words.

Example:

"the sky is blue"

↓

"blue is sky the"

Pattern Learned

Split → Process Array → Join

String[] arr = s.trim().split("\\s+");

perform operation on arr

return String.join(" ", arr);

Two Pointer Array Reversal

int l = 0;
int r = arr.length - 1;

while (l < r) {

    swap(arr[l], arr[r]);

    l++;
    r--;
}

Why "\\s+"?

\\s  = any whitespace character
+    = one or more occurrences

This handles:

"hello world"
"hello   world"
"   hello     world   "

all correctly.

Common Use Cases

- Reverse words in a sentence
- Reverse an array
- Reverse characters in a string
- Palindrome checking
- Two-pointer array problems
*/