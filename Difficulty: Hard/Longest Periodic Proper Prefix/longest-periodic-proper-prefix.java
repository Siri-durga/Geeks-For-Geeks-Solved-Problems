class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return -1;

        int[] z = buildZ(s);

        int ans = -1;
        for (int p = 1; p < n; p++) {
            if (z[p] >= n - p) ans = p; // keep the largest valid p
        }

        return ans == 0 ? -1 : ans;
    }

    private int[] buildZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
