class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0,remainder,count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            prefixSum += num;
            remainder = ((prefixSum % k) + k) % k;
            if(map.containsKey(remainder)){
                count+=map.get(remainder);
            }
                map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}