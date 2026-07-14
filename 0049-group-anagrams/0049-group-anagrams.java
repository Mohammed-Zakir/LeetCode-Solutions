class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Frequency array
            int[] freq = new int[26];

            // Count every character
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Convert frequency array into String key
            StringBuilder sb = new StringBuilder();

            for (int count : freq) {
                sb.append(count).append('#');
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}