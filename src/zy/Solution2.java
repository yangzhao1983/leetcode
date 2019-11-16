package zy;

/**
 * Created by kaiser_zhao on 20/06/2019.
 */
public class Solution2 {
    private static int IndexOfOriginal(String S, String x) {
        int[] sOffSets = getOffSets(S);
        int[] xOffSets = getOffSets(x);
        int i = 0;
//        while(int i = 0; i<sOffSets.length; i++){
//            if(){
//
//            }
//        }
        return 0;
    }

    /**
     * For every S, Return int[]
     *     where int[i] = s[i+1] - s[i]
     *
     *
     */
    private static int[] getOffSets(String s){
        int[] offSets = new int[s.length()-1];
        for(int i = 1; i < s.length(); i++){
            offSets[i-1] = s.charAt(i) - s.charAt(i-1);
        }
        return offSets;
    }
}
