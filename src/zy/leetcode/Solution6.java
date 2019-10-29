package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/4.
 */
public class Solution6 {
    public final static void main(String...strings){
        //convert("PAYPALISHIRING",4);
        System.out.println(convert("afxcvsqepewrnpgggcjelmbypbeaqliqqhvlzlsqpqiefqnlsysfntdcwhenuodkvyywlsociwjnoyaiysnlnqnkatxuhchcd"
                ,60));
    }

//    public static String convert2(String s, int numRows) {
//        char[] cs = new char[s.length()];
//        int cycleLen = 2 * (numRows-1) -2 ;
//        for(int i = 0; i<s.length();i++){
//            int left = i%(numRows-1);
//            int num = i/(numRows-1);
//            int cycleNum = i/cycleLen;
//            int cycleLeft = i%cycleLen;
//
//            if(left == 0){
//                cs[cycleNum] = s.charAt(i);
//            }else if (true){
//
//            }
//
//        }
//    }
    /**
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * A[0]           A[6]             A[12]    (i%6==0, i/6==0), space1,           space2,         ( i%6==0,i/6==1),..
     * A[1]      A[5] A[7]       A[11]          (i%6==1, i/6==0), space1,          (i%6==5, i/6==0), (i%6==1, i/6==1),...
     * A[2] A[4]      A[8] A[10]                (i%6==2, i/6==0), (i%6==4, i/6==0), space1,         (i%6==2, i/6==1)
     * A[3]           A[9]                      (i%6==3, i/6==0), space1,           space2,         (i%6==3, i/6==1
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(s.length()<1){
            return "";
        }

        if(numRows<2){
            return s;
        }

        int oneCycleNum = numRows*2 -2;
        int indexInCycle = (s.length()-1)%oneCycleNum;
        int cycleNum = (s.length()-1)/oneCycleNum;

        int numCols = cycleNum * (numRows-1) ;
        if(indexInCycle>=0 && indexInCycle <numRows){
            numCols++;
        }else{
            numCols += indexInCycle-numRows + 2;
        }
        int index = 0;
        char[] cs = new char[s.length()];
        int csIndex = 0;
        for(int row = 0; row<numRows; row++){
            for(int col = 0; col <numCols; col++){
                if (col%(numRows-1)==0) {
                    index = oneCycleNum * (col/(numRows-1)) + row;
                    if(index < s.length()){
                        System.out.print(s.charAt(index));

                        System.out.print("\t");
                        cs[csIndex++] = s.charAt(index);
                    }
                }else if(col%(numRows-1)+row + 1==numRows){
                    index = oneCycleNum *(col/(numRows-1)) + numRows + col%(numRows-1)-1;
                    if(index < s.length()) {
                        System.out.print(s.charAt(index));
                        cs[csIndex++] = s.charAt(index);
                        System.out.print("\t");
                    }
                }else{
                    System.out.print(" ");
                    System.out.print("\t");
                }
            }
            System.out.print("\n");
        }
        return String.copyValueOf(cs);

    }
}
