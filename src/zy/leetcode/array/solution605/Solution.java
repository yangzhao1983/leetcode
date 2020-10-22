package zy.leetcode.array.solution605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            boolean left = i == 0? true : flowerbed[i-1] != 1;
            boolean right = i == flowerbed.length-1 ? true : flowerbed[i+1] != 1;
            if(left && right){
                max ++;
                flowerbed[i] = 1;
            }
        }
        return max >= n;
    }
}
