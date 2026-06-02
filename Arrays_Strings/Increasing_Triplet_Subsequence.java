package Arrays_Strings;

/*
Problem: Increasing Triplet Subsequence

Approach:
- We need to determine whether there exist three numbers:
      first < second < third
- Instead of checking all triplets, keep track of:
      first  = smallest number seen so far
      second = smallest number greater than first
- For each number:
    1. If it is smaller than or equal to first, update first.
    2. Else if it is smaller than or equal to second, update second.
    3. Otherwise, the number is greater than both first and second,
       so an increasing triplet exists.

Why it works:
- first stores the best candidate for the first element.
- second stores the best candidate for the second element.
- If we find a number greater than second, we have:
      first < second < currentNumber
- Therefore, an increasing triplet exists.

Example:
nums = [2,1,5,0,4,6]

first = 2
first = 1
second = 5
first = 0
second = 4
6 > second

Triplet found:
0 < 4 < 6

Answer = true

Time Complexity: O(n)
- We traverse the array only once.

Space Complexity: O(1)
- Only two variables are used.
*/

public class Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {

        // Smallest number seen so far.
        int first = Integer.MAX_VALUE;

        // Smallest number greater than first.
        int second = Integer.MAX_VALUE;

        for (int num : nums) {

            // Update the smallest number.
            if (num <= first) {
                first = num;
            }

            // Update the second smallest number.
            else if (num <= second) {
                second = num;
            }

            // Found a number greater than both.
            else {
                return true;
            }
        }

        return false;
    }
}

/*
Key Insight

We do NOT need to store the actual triplet.

We only need to track:

first  = smallest element
second = smallest element greater than first

If a number larger than second appears:

first < second < currentNumber

Triplet found.

Pattern Learned

Greedy Tracking

int first = Integer.MAX_VALUE;
int second = Integer.MAX_VALUE;

for (int num : nums) {

    if (num <= first)
        first = num;

    else if (num <= second)
        second = num;

    else
        return true;
}

Why use <= ?

It correctly handles duplicates.

Example:

[1,1,2,3]

The second 1 updates first instead of incorrectly
being treated as a larger element.


*/