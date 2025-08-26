class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int i = 0, j = 0;
        int n1 = s1.length(), n2 = s2.length();
        
        while (i < n1 && j < n2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; // move s1 pointer if match
            }
            j++; // always move s2 pointer
        }
        
        return i == n1; // true if all of s1 is matched
    }
};
