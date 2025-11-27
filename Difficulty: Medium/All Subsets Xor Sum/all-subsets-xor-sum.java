class Solution {
    int subsetXORSum(int arr[]) {
        int n = arr.length;
        int orVal = 0;

        for (int x : arr) {
            orVal |= x;
        }

        return orVal * (1 << (n - 1));
    }
}
