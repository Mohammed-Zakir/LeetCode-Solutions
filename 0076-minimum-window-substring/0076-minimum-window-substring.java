import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int matched = 0;

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Store frequencies of characters in t
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // Expand window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Character frequency matched
            if (need.containsKey(ch)
                    && need.get(ch).intValue() == window.get(ch).intValue()) {
                matched++;
            }

            // Shrink window
            while (matched == need.size()) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftchar = s.charAt(left);
                window.put(leftchar, window.get(leftchar) - 1);

                if (need.containsKey(leftchar)
                        && window.get(leftchar) < need.get(leftchar)) {
                    matched--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}