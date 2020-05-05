package zy.leetcode.string.solution68;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 1. find enough words for a line.
     * if words[start..end] ∑len(start..end+1) + (end + 1 -start) > maxWidth
     *
     * 2. generate line: base number of spaces (maxWidth - ∑len(start..end))/end-start
     * number of additional space:  (maxWidth - ∑len(start..end))%end-start
     *  0~(maxWidth - ∑len(start..end))%end-start-1
     *
     * 3. last line, word1+space+word2..
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int cur = start;
        int len = 0;
        while(start < words.length){
            while(cur < words.length && len <= maxWidth){
                if(len > 0){
                    len++;
                }
                len += words[cur].length();
                cur++;
            }

            if(len > maxWidth){
                int originalLen = len - 1 - words[cur-1].length();

                ans.add(generateLine(words, start, cur-2, originalLen - (cur-2-start), maxWidth));

                start = cur -1;
                cur = start;
                len = 0;
            }else{
                break;
            }
        }

        ans.add(makeLastLine(words, start, maxWidth));
        return ans;
    }

    private String generateLine(String[] words, int start, int end, int sumLen, int maxWidth){
        String s = "";
        if(end == start){
            int len = words[start].length();
            s += words[start];
            for(int i = len; i<maxWidth;i++){
                s += " ";
            }
            return s;
        }
        int numOfBaseSpace = (maxWidth - sumLen)/(end - start);
        int numOfAddSpace = (maxWidth - sumLen)%(end-start);

        String baseSpaces = "";
        for(int i = 0; i < numOfBaseSpace; i++){
            baseSpaces += " ";
        }
        for(int i = start; i<=end; i++){
            s += words[i];
                if(i < end){
                s += baseSpaces;
                if(i - start < numOfAddSpace){
                    s += " ";
                }
            }
        }
        return s;
    }

    private String makeLastLine(String[] words, int start, int maxWidth){
        String last = "";
        for(int i = start; i<words.length;i++){
            last += words[i];
            if(i<words.length-1){
                last += " ";
            }
        }
        int len = last.length();
        for(int i = len; i<maxWidth;i++){
            last += " ";
        }
        return last;
    }

    @Test
    public void test1(){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        Solution sol = new Solution();
        List<String> ans = sol.fullJustify(words, maxWidth);
        System.out.println();
    }

    @Test
    public void test2(){
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        Solution sol = new Solution();
        List<String> ans = sol.fullJustify(words, maxWidth);
        System.out.println();
    }
}
