import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int target, int k, int start, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // Base case: found a valid combination
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If sum < 0 or too many numbers, stop
        if (target < 0 || current.size() > k) return;

        // Try numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(target - i, k, i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
