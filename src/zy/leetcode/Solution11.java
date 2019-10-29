package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/19.
 */
public class Solution11 {
    public static void main(String...strings){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea2(new int[]{1,1}));
    }

    public static int maxArea2(int[] height){
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while(left < right){
            int curArea = getWater(height, left, right);
            if(curArea > area){
                area = curArea;
            }
            if(height[left] > height[right]){
                right--;
            }else{
                left ++;
            }
        }
        return area;
    }

    public static int maxArea(int[] height) {
        int[] rel = new int[2];

        rel[0] = 0;
        rel[1] = height.length -1;
        int water = getWater(height, rel[0], rel[1]);
        for(int i = 0; i<height.length-1; i++){
            for(int j = height.length-1; j> i; j--){
               if(j-i > rel[1] - rel[0] || Math.min(height[j],height[i])> Math.min(height[rel[0]], height[rel[1]])){
                   int newWater = getWater(height, i, j);
                   if(newWater>water){
                       water = newWater;
                       rel[0] = i;
                       rel[1] = j;
                   }
               }
            }
        }
        return water;
    }

    private static int min(int a1, int a2){
        return a1>a2?a2:a1;
    }
    private static int getWater(int[]height, int i, int j){
        return Math.abs(j-i) * Math.min(height[i], height[j]);
    }
}
