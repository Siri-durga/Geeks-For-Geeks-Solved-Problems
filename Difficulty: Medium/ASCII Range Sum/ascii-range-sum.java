import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> firstOccurrence = new HashMap<>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        
        // Store first and last occurrences
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!firstOccurrence.containsKey(ch)) {
                firstOccurrence.put(ch, i);
            }
            lastOccurrence.put(ch, i);  // Always update to last seen index
        }
        
        // Compute ASCII sums for characters with multiple occurrences
        for (char ch : firstOccurrence.keySet()) {
            int first = firstOccurrence.get(ch);
            int last = lastOccurrence.get(ch);
            
            if (first != last) {
                int sum = 0;
                for (int i = first + 1; i < last; i++) {
                    sum += (int) s.charAt(i);
                }
                if (sum > 0) {
                    result.add(sum);
                }
            }
        }
        
        return result;
    }
}
