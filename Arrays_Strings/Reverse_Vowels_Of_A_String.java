package Arrays_Strings;

/*
Problem: Reverse Vowels of a String

Approach:
- Convert the string into a character array because strings in Java are immutable.
- Use two pointers:
    - i starts from the beginning.
    - j starts from the end.
- Move i forward until it points to a vowel.
- Move j backward until it points to a vowel.
- Swap the vowels at i and j.
- Continue until the pointers meet or cross.
- Convert the character array back to a string and return it.

Why it works:
- We only care about reversing vowels, not the entire string.
- The left pointer finds the next vowel from the front.
- The right pointer finds the next vowel from the back.
- Swapping them places each vowel in its correct reversed position.

Example:
s = "hello"

Vowels = ['e', 'o']

Swap 'e' and 'o':

"holle"

Answer = "holle"

Time Complexity: O(n)
- Each pointer moves through the string at most once.

Space Complexity: O(n)
- Character array is used to modify the string.
*/

public class Reverse_Vowels_Of_A_String {

    public String reverseVowels(String s) {

        // Convert string to character array for modification.
        char[] arr = s.toCharArray();

        // Two pointers.
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            // Move left pointer until a vowel is found.
            while (i < j && !isVowel(arr[i])) {
                i++;
            }

            // Move right pointer until a vowel is found.
            while (i < j && !isVowel(arr[j])) {
                j--;
            }

            // Swap the vowels.
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            // Move both pointers inward.
            i++;
            j--;
        }

        // Convert array back to string.
        return new String(arr);
    }

    // Check whether a character is a vowel.
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

/*
Key Insight

We only need to swap vowels, while all consonants remain in their
original positions.

Pattern Learned

Two Pointer Technique

int i = 0;
int j = arr.length - 1;

while (i < j) {

    while (i < j && condition_not_met) i++;

    while (i < j && condition_not_met) j--;

    swap();

    i++;
    j--;
}

Why Two Pointers?

- One pointer searches from the left.
- One pointer searches from the right.
- When both find valid characters (vowels), swap them.
- This avoids extra traversals and keeps the solution efficient.

Common Use Cases

- Reverse vowels
- Reverse only letters
- Palindrome problems
- Sorted array pair problems
- Container With Most Water
*/