package Arrays_Strings;

/*
Problem: Product of Array Except Self

Approach:
- For each index, we need:
    answer[i] = product of all elements on the left
              * product of all elements on the right
- First pass:
    Store left products in the answer array.
- Second pass:
    Traverse from the right while maintaining a running right product.
    Multiply the current answer value by the right product.

Why it works:
- First loop gives the product of all elements before each index.
- Second loop provides the product of all elements after each index.
- Multiplying both gives the required answer.

Example:
nums = [1,2,3,4]

Left products:
[1,1,2,6]

After multiplying with right products:
[24,12,8,6]

Time Complexity: O(n)
- Two linear traversals.

Space Complexity: O(1)
- Ignoring the output array.
*/

public class Product_Of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // Stores left products initially.
        int[] ans = new int[n];

        // Nothing exists to the left of index 0.
        ans[0] = 1;

        // Build left products.
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Running product of elements on the right.
        int rightp = 1;

        // Multiply left products with right products.
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * rightp;
            rightp *= nums[i];
        }

        return ans;
    }
}

/*
Key Insight

answer[i] =
(Product of elements on the left)
*
(Product of elements on the right)

Pattern Learned

Prefix Product + Suffix Product

Pass 1:
Store left products.

Pass 2:
Maintain right product and combine.

Common Use Cases

- Product Except Self
- Prefix/Suffix Sum problems
- Trapping Rain Water
- Prefix/Suffix Maximum problems
*/