class Solution {
    public int singleNonDuplicate(int[] arr) {

        int n = arr.length;

        // Only one element
        if (n == 1) {
            return arr[0];
        }

        // Check first element
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        // Check last element
        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = (low + high) / 2;

            // Single element found
            if (arr[mid] != arr[mid + 1] &&
                arr[mid] != arr[mid - 1]) {

                return arr[mid];
            }

            // We are in the LEFT half
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {

                low = mid + 1;
            }

            // We are in the RIGHT half
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}