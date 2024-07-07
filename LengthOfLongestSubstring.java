class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if(len == 1 || len == 0) {
            return len;
        } 

        int start = 0; 
        int end = start;
        int maxWindowSize = 0;

        while(end < len) {

            if(end < start) {
                end = start;
            }

            String substr = s.substring(start, end + 1); //substr = cabc
            
            if(containRepeatingCharacters(substr)) {
                start++; //2
            }
            else {
                end++; //end = 4
            }
            int windowSize = (end - start);
            maxWindowSize = windowSize > maxWindowSize ? windowSize : maxWindowSize; //3
            
        }

        return maxWindowSize;
    }

    private boolean containRepeatingCharacters(String s) {
        boolean containRepeatingCharacters = false;

        for(int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    return true;
                }
            }
        }

        return containRepeatingCharacters;
    }
}
