import java.util.HashMap;

class Solution {
    public int countBalanced(String[] arr) {
        int totalBalanced = 0;
        HashMap<Integer, Integer> balanceMap = new HashMap<>();
        balanceMap.put(0, 1); // balance 0 has occurred once (initial state)

        int balance = 0;
        for (String s : arr) {
            for (char ch : s.toCharArray()) {
                if (isVowel(ch)) balance++;
                else balance--;
            }
            totalBalanced += balanceMap.getOrDefault(balance, 0);
            balanceMap.put(balance, balanceMap.getOrDefault(balance, 0) + 1);
        }
        return totalBalanced;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
