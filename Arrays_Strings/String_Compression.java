package Arrays_Strings;

/*
Problem: String Compression

Approach:
- Process one group of consecutive characters at a time.
- Use two pointers:
    - read  -> scans the original array.
    - write -> writes the compressed result back into the same array.
- Count how many times the current character appears consecutively.
- Write the character once.
- If its count is greater than 1, write the digits of the count.
- Return the final length of the compressed array.

Why it works:
- Each group is processed exactly once.
- The character is written once, followed by its frequency if needed.
- The compressed result is stored directly in the input array.

Example:
chars = ['a','a','b','b','c','c','c']

Groups:
aa  -> a2
bb  -> b2
ccc -> c3

Compressed array:
[a,2,b,2,c,3]

Return = 6

Time Complexity: O(n)
- Every character is visited once.

Space Complexity: O(1)
- Compression is done in-place.
*/

public class String_Compression {

    public int compress(char[] chars) {

        // Pointer to read the original array.
        int read = 0;

        // Pointer to write the compressed result.
        int write = 0;

        while (read < chars.length) {

            // Current group character.
            char current = chars[read];

            // Count occurrences of current character.
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                count++;
                read++;
            }

            // Write the character.
            chars[write] = current;
            write++;

            // Write frequency if count > 1.
            if (count > 1) {

                String freq = String.valueOf(count);

                for (char c : freq.toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }

        // Length of compressed array.
        return write;
    }
}

/*
Key Insight

This is NOT a frequency-counting problem.

We only compress consecutive groups.

Example:

[a,a,b,a]

becomes:

[a,2,b,a]

NOT:

[a,3,b]

Pattern Learned

Read Pointer + Write Pointer

read  -> finds a group
count -> counts the group size
write -> stores compressed result

Pseudo Pattern:

while(read < n){

    find group

    write character

    if(count > 1)
        write count
}

Why convert count to String?

For counts greater than 9.

Example:

count = 12

Write:

a
1
2

instead of:

a
12

because the array stores characters.
*/