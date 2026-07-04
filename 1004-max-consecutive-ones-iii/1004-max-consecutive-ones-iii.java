class Solution {

    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink if window becomes invalid
            while (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // Window is valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}