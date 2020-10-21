package zy.leetcode.string.solution926;

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int ni = 0;
        int ti = 0;
        while(ti < typed.length()){
            if( ni < name.length() && name.charAt(ni) == typed.charAt(ti)){
                ni++;
                ti++;
            }else if(ti > 0 && typed.charAt(ti) == typed.charAt(ti-1)){
                ti++;
            }else{
                return false;
            }
        }
        return ni == name.length();
    }
}
