package zy.leetcode.stack.solution71;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {

    /**
     * removing tailing "/"
     * removing single "."
     * transfer doubling "/" to single "/"
     * if hit "..", removing previous dir if exist
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();

        Set<String> exp = new HashSet<>();
        exp.add("");
        exp.add(".");
        exp.add("..");
        String[] ss = path.split("/");

        for(int i = 0; i < ss.length; i++){
            if(!exp.contains(ss[i])){
                stack.push(ss[i]);
            }else if("..".equals(ss[i]) && !stack.isEmpty()){
                stack.pop();
            }
        }
        String ans = "";
        for(String s : stack){
            ans = s + "/" + ans;
        }

        if(ans.length() > 0){
            ans = ans.substring(0,ans.length()-1);
        }
        return "/"+ ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("/home", sol.simplifyPath("/home/"));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals("/c", sol.simplifyPath("/a/./b/../../c/"));
    }
}
