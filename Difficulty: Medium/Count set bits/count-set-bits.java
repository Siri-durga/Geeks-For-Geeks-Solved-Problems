class Solution {
    public static int countSetBits(int n) {
        if (n == 0) return 0;
        
        int x = largestPowerOf2(n);
        
        // Count bits till (2^x - 1)
        int bitsUpto2x = x * (1 << (x - 1));
        
        // Count MSB bits from 2^x to n
        int msbBits = n - (1 << x) + 1;
        
        // Recurse for the remaining part
        int rest = countSetBits(n - (1 << x));
        
        return bitsUpto2x + msbBits + rest;
    }
    
    // Find largest x such that 2^x <= n
    private static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n) {
            x++;
        }
        return x;
    }
}
