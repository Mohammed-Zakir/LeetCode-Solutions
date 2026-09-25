class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0,low  = 1;
        for(int pile : piles){
            high = Math.max(high,pile);
        } 
        while(low<high){
            int speed = low+(high - low)/2;
            int hours = 0;
            for(int pile : piles){
                hours+=(pile+speed-1)/speed;
            }
            if(hours<=h){
                high = speed; 
            }
            else{
                low=speed+1;
            }
        }
        return low;
    }
}