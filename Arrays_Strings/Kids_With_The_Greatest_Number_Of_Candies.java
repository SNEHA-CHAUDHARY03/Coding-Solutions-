package Arrays_Strings;

import java.util.ArrayList;
import java.util.List;

/*
Problem: Kids With the Greatest Number of Candies

Approach:
- Find the maximum number of candies any kid currently has.
- For each kid, add the extraCandies and check if the total is
  greater than or equal to the maximum.
- If yes, add true to the answer list.
- Otherwise, add false.

Why it works:
- A kid can have the greatest number of candies only if their
  current candies plus extraCandies is at least equal to the
  current maximum candies among all kids.
- Therefore, we only need to find the maximum once and compare
  each kid against it.

Example:
candies = [2,3,5,1,3]
extraCandies = 3

Maximum candies = 5

Kid 1: 2 + 3 = 5  -> true
Kid 2: 3 + 3 = 6  -> true
Kid 3: 5 + 3 = 8  -> true
Kid 4: 1 + 3 = 4  -> false
Kid 5: 3 + 3 = 6  -> true

Answer:
[true, true, true, false, true]

Time Complexity: O(n)
- One pass to find the maximum.
- One pass to build the answer.

Space Complexity: O(1)
- Ignoring the output list.
*/

public class Kids_With_The_Greatest_Number_Of_Candies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // Stores the final answer.
        List<Boolean> ans = new ArrayList<>();

        // Find the maximum candies any kid currently has.
        int max = 0;

        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        // Check if each kid can reach or exceed the maximum
        // after receiving extraCandies.
        for (int candy : candies) {
            ans.add(candy + extraCandies >= max);
        }

        return ans;
    }
}