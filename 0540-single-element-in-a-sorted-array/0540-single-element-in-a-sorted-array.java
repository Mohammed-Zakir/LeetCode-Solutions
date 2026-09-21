class Solution {
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Correct pair → single element is on the right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }

            // Broken pair → single element is at mid or on the left
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}