class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> answer = new HashSet<>();

        for(int num : nums1){
            seen.add(num);
        }

        for(int num : nums2){

            if(seen.contains(num)){
                answer.add(num);
            }
        }

        int[] result = new int[answer.size()];
        int index = 0;

        for(int num : answer){
            result[index++] = num;
        }

        return result;
    }
}