package zy.leetcode;

/**
 * Created by kaiser_zhao on 05/05/2019.
 */
public class Solution28 {
    public static void main(String...strings){
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hello", "llo"));
        System.out.println(strStr("hello", "llo8"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("aaaaa", ""));
        System.out.println(strStr("", "a"));
        System.out.println(strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 ){
            return 0;
        }
        if(haystack == null || haystack.length() == 0){
            return -1;
        }

        for (int hIndex = 0; hIndex <= haystack.length() - needle.length(); hIndex++){
            if(haystack.charAt(hIndex) == needle.charAt(0)){
                int i = 0;
                while(i<needle.length() && i < haystack.length() - hIndex){
                    if(haystack.charAt(hIndex+i) == needle.charAt(i)){
                        i++;
                    }else{
                        break;
                    }
                }
                if (i == needle.length()){
                    return hIndex;
                }
            }
        }
        return -1;
    }
}
