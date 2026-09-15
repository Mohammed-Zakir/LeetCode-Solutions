class Solution {
    public int findMaxLength(int[] nums) {
        int prefixSum = 0,Maxlength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0)
                prefixSum--;
            else 
                prefixSum++;
            if(map.containsKey(prefixSum)){
                int length  = i - map.get(prefixSum);
                Maxlength = Math.max(length,Maxlength);
            }
            else { 
                map.put(prefixSum,i);
            }
        }
        return Maxlength;
    }
}