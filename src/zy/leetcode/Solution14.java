package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/20.
 */
public class Solution14 {

    public static void main(String...strings){
        String [] strs= {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(strs).equals("fl"));

        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix2(strs2).equals(""));

        String[] strs3 = {};
        System.out.println(longestCommonPrefix2(strs3).equals(""));


        String[] strs4 = {"","b"};
        System.out.println(longestCommonPrefix2(strs4).equals(""));

        String[] strs5 = {""};
        System.out.println(longestCommonPrefix2(strs5).equals(""));
    }

    /**
     * given i
     * str[i], if ls = i, break
     *
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        String rel = "";
        while(true){
            boolean end = false;
            boolean fail = false;
            String cur = "";
            for(String str:strs){
               if(str.length() == 0){
                   return "";
               }else if (str.length() == i){
                   end = true;
                   break;
               }else{
                   String s = str.substring(i,i+1);
                   if(cur.equals("")){
                       cur = s;
                   }else if(!cur.equals(s)){
                       end = true;
                       fail = true;
                       break;
                   }
               }
            }
            if(end){
                break;
            }
            if(!fail){
                rel = rel + cur;
            }
            i++;
        }
        return rel;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length==0){
            return "";
        }

        int min = Integer.MAX_VALUE;
        for(String str : strs){
            if(str.length()<min){
                min = str.length();
            }
        }
        String rel = "";
        if(min > 0){
            for(int i = 0; i<min; i++){
                boolean end = false;
                String cur = strs[0].substring(i,i+1);
                for(String str : strs){
                    if(!str.substring(i,i+1).equals(cur)){
                        end = true;
                        break;
                    }
                }
                if(end){
                    break;
                }else{
                    rel = rel + cur;
                }
            }
        }
        return rel;
    }
}
