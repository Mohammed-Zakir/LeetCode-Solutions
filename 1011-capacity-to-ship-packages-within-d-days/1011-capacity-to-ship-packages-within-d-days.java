class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (low < high) {

            int capacity = low + (high - low) / 2;

            int requiredDays = 1;
            int currentLoad = 0;
            // Calculate how many days are needed
            // with this capacity
            for (int weight : weights) {
                if (currentLoad + weight > capacity) {
                    requiredDays++;
                    currentLoad = weight;
                } 
                else {
                    currentLoad += weight;
                }
            }
            if (requiredDays <= days) {
                high = capacity;
            }
            else {
                low = capacity + 1;
            }
        }
        return low;
    }
}