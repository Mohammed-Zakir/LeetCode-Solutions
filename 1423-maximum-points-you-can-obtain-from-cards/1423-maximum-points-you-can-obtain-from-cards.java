class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k==n){
            int total = 0;
            for(int nums : cardPoints){
                total+=nums;
            }
            return total;
        }
        int totalSum = 0;
        for(int nums : cardPoints){
            totalSum += nums;
        }
        int windowSize = n - k;
        int windowSum = 0;
        for(int i = 0;i<windowSize;i++){
            windowSum+=cardPoints[i];
        }
        int minWindowSum = windowSum;
        for(int right = windowSize;right<n;right++){
            windowSum -= cardPoints[right - windowSize];
            windowSum += cardPoints[right];
            minWindowSum = Math.min(minWindowSum,windowSum);
        }
        return totalSum - minWindowSum;
    }
}