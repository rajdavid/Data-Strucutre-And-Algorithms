package DynamicProgramming;

import java.util.HashMap;

public class LongestPalindromicSubsequnce {
	public int longestPalindromeSubseq(String s) {
	    
        int n = s.length();
       if(n==0 || s==null || s.equals("")){
           return 0;
       }
       if(s.length()==1){
           return 1;
       }
        int minOperations = getPalin(s, 0, s.length()-1, new HashMap<String,Integer>());
       return s.length() - minOperations;
   }
    public int  getPalin(String s, int start, int end , HashMap<String,Integer> hmp){
         String key = start+":"+end;
           if(hmp.containsKey(key)){
           return hmp.get(key);
           }    
           int minOp;
       if(start>end){
           minOp = 0;
       }else if (start == end) {
           minOp =  0;
       }else if(s.charAt(start) == s.charAt(end)){
           minOp = getPalin(s,start+1,end-1,hmp);
       }else{
           minOp = Math.min(1 + getPalin(s,start+1,end,hmp),
                       1 + getPalin(s,start,end-1,hmp));
       }
       hmp.put(key,minOp);
       return minOp;
    }
   

}
