package zy.leetcode.string.solution657;

public class Solution {
    public boolean judgeCircle(String moves) {
        int hor = 0;
        int ver = 0;
        for(int i = 0; i < moves.length(); i++){
            String cur = moves.substring(i, i+1);
            if(cur.equals("R")){
                hor++;
            }else if (cur.equals("L")){
                hor--;
            }else if (cur.equals("U")){
                ver++;
            }else{
                ver--;
            }
        }
        return hor==0 && ver==0;
    }
}
