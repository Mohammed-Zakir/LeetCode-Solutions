class Solution {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    // Find FIRST occurrence
    private int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                answer = mid;
                right = mid - 1;       // keep looking LEFT
            }
            else if (nums[mid] < target) {
                left = mid + 1;        // target is RIGHT
            }
            else {
                right = mid - 1;       // target is LEFT
            }
        }

        return answer;
    }

    // Find LAST occurrence
    private int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;        // keep looking RIGHT
            }
            else if (nums[mid] < target) {
                left = mid + 1;        // target is RIGHT
            }
            else {
                right = mid - 1;       // target is LEFT
            }
        }

        return answer;
    }
}
