class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;
        int candidate1 = 0, candidate2 = 1; // initialize to different values
        int count1 = 0, count2 = 0;

        // 1st pass: Find potential candidates
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass: Count actual occurrences
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        Collections.sort(result);
        return result;
    }
}
