class Solution {
    public int maxVowels(String s, int k) {
        int vowelcount = 0;
        for(int i = 0;i<k;i++){
            if(isvowel(s.charAt(i))){
                vowelcount++;
            }
        }
        int maxcount = vowelcount;
        for(int right = k;right<s.length();right++){
            if(isvowel(s.charAt(right-k))){
                vowelcount--;
            }
            if(isvowel(s.charAt(right))){
                vowelcount++;
            }
        maxcount = Math.max(maxcount,vowelcount); 
        }
    return maxcount;
    }
    public boolean isvowel(char ch){
        return ch == 'a' || ch == 'e' || ch=='i' || ch == 'o' || ch=='u';
    }
}