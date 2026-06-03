package Arrays_Strings;

/*
Problem: Move Zeroes

Approach:
- Use a variable count to track the position where the next non-zero element should be placed.
- Traverse the array from left to right.
- Whenever a non-zero element is found:
    - Place it at index count.
    - Increment count.
- After all non-zero elements are moved to the front:
    - Fill the remaining positions with 0.

Why it works:
- All non-zero elements keep their original relative order.
- Every non-zero element is shifted to the earliest available position.
- Once all non-zero elements are placed, the remaining positions must be zeroes.
- The operation is performed directly on the original array (in-place).

Example:
nums = [0,1,0,3,12]

Step 1: Move non-zero elements forward

1 -> nums[0]
3 -> nums[1]
12 -> nums[2]

Array becomes:
[1,3,12,3,12]

count = 3

Step 2: Fill remaining positions with zeroes

[1,3,12,0,0]

Final Answer:
[1,3,12,0,0]

Time Complexity: O(n)
- First loop visits every element once.
- Second loop fills remaining positions.
- Total operations are proportional to n.

Space Complexity: O(1)
- No extra array is used.
- Modification is done in-place.
*/

public class Move_Zeroes {

    public void moveZeroes(int[] nums) {

        // Position where the next non-zero element should be placed.
        int count = 0;

        // Traverse the array.
        for (int i = 0; i < nums.length; i++) {

            // If current element is non-zero.
            if (nums[i] != 0) {

                // Move it to the next available position.
                nums[count] = nums[i];

                // Move count forward.
                count++;
            }
        }

        // Fill all remaining positions with zeroes.
        while (count < nums.length) {

            nums[count] = 0;
            count++;
        }
    }
}

/*
Key Insight

We are NOT swapping zeroes with non-zeroes.

Instead:

1. Collect all non-zero elements at the beginning.
2. Fill the rest of the array with zeroes.

Example:

[0,1,0,3,12]

Non-zero elements:
1,3,12

Place them at the front:

[1,3,12,_,_]

Fill remaining spots:

[1,3,12,0,0]

Pattern Learned

Array Compaction Pattern

count -> next position to place a valid element

for(each element){

    if(element is valid){
        place it at count
        count++
    }
}

fill remaining positions

When to use this pattern?

Whenever you need to:
- Move unwanted elements to the end.
- Remove elements in-place.
- Keep only valid elements.
- Maintain relative order of remaining elements.

Examples:
- Move Zeroes
- Remove Element
- Remove Duplicates from Sorted Array
- Compact valid entries in an array

Interview Trick

Think of count as:

"How many valid elements have I seen so far?"

Every non-zero element gets written at index count.

After processing:
- Indices [0 ... count-1] contain all non-zero elements.
- Indices [count ... n-1] are filled with zeroes.
*/