class Solution {
    public int findIndex(String s) {
        // code here
        int n=s.length();
        int obc=0;
        int cbc=0;
        int position=-1;
        for(int i=0;i<n;++i){
            if(s.charAt(i)==')'){
                cbc++;
            }
        }
        int leftobc=0;
        int rightcbc=0;
        for(int k=0;k<=n;++k){
            if(k==0){
                leftobc=0;
                rightcbc=cbc;
            }
            else if( k > 0){
                if(s.charAt(k-1)=='('){
                    leftobc++;
                }
                else{
                    rightcbc--;
                    
                }
            }
            if(leftobc==rightcbc){
                position=k;
                break;
            }
        }
        return position;
    }
}