import java.util.*;

class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate(n, "", res);
        return res;
    }
    
    private void generate(int n, String current, ArrayList<String> res) {
        if (n == 0) {
            res.add(current);
            return;
        }
        generate(n - 1, current + "0", res); // put 0
        generate(n - 1, current + "1", res); // put 1
    }
}
