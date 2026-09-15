class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0,length = 0,remainder;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            prefixSum +=nums[i];
            remainder = prefixSum % k;
            if(remainder < 0){
                remainder+=k;
            }
            if(map.containsKey(remainder)){
                length = i - map.get(remainder);
                if(length>=2)
                    return true; 
            }
            else{   
                map.put(remainder,i);
            }
        }
        return false;
    }
}