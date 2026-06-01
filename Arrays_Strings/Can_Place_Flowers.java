package Arrays_Strings;

/*
Problem: Can Place Flowers

Approach:
- Traverse each plot in the flowerbed.
- A flower can be planted only if:
    1. The current plot is empty (0).
    2. The left plot is empty OR does not exist.
    3. The right plot is empty OR does not exist.
- If all conditions are satisfied:
    - Plant a flower by setting flowerbed[i] = 1.
    - Decrease n because one flower has been successfully planted.
- After traversing the entire flowerbed, check if we planted at least n flowers.

Why it works:
- We greedily plant a flower whenever a valid position is available.
- Planting at the earliest valid position never reduces the number of flowers
  that can be planted later.
- Updating the flowerbed is important because future placements depend on
  flowers planted during the current traversal.

Example:
flowerbed = [1,0,0,0,1]
n = 1

Index 2:
left = 0
current = 0
right = 0

Plant flower:

[1,0,1,0,1]

n becomes 0

Answer = true

Time Complexity: O(n)
- We traverse the flowerbed only once.

Space Complexity: O(1)
- No extra space is used.
*/

public class Can_Place_Flowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        // Traverse each plot in the flowerbed.
        for (int i = 0; i < flowerbed.length; i++) {

            // Check if the current position is valid for planting.
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                // Plant a flower.
                flowerbed[i] = 1;

                // One required flower has been placed.
                n--;
            }
        }

        // If n is 0 or less, we successfully planted enough flowers.
        return n <= 0;
    }
}
//Key Insight
// A flower can be planted at index i if:

// Current plot is empty
// AND
// Left neighbor is empty (or doesn't exist)
// AND
// Right neighbor is empty (or doesn't exist)
//Pattern Learned
// flowerbed[i] == 0
// && (i == 0 || flowerbed[i - 1] == 0)
// && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)

// Greedy Algorithm

// Whenever a valid position is available,
// plant the flower immediately.

// Why?

// Because delaying the placement provides no benefit and cannot
// increase the total number of flowers that can be planted.