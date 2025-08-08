class Solution {
    int getLPSLength(String s) {
        int n = s.length();
        int[] lps = new int[n]; // lps[i] stores length of longest prefix-suffix for s[0..i]
        
        int len = 0; // length of previous longest prefix-suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // backtrack
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[n - 1]; // last value is the answer
    }
}
