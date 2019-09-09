package zy.leetcode.queue.solution621;

import java.util.Arrays;

/**
 * Created by kaiser_zhao on 2019/9/6.
 */
public class ByArray {
    public static void main(String...strings){
        testcase1();
        testcase2();
    }

    private static void testcase1(){
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks, 2));
    }

    private static void testcase2(){
        char[] tasks = new char[]{'A','B','C','D','E','A','B','C','D','E'};
        System.out.println(leastInterval(tasks, 4));
    }

    public static int leastInterval(char[] tasks, int n) {
        // 1. transform tasks to array, since tasks are marked by capital letters from A to Z,
        // the max number of task category is 26
        // thus, use the index of array item to represent the category of a tasks:
        // for example: index 0 may refer to A, index 1 may refer to B...
        // Use the value of the item to represent the number of tasks in the same category
        int[] categories = new int[26];
        Arrays.fill(categories,0);
        for( char c : tasks){
            categories[c-'A'] ++;
        }

        // 2. sort the array
        Arrays.sort(categories);

        // 3. define the ans as time, for each of the task category, get it out by descending order of their numbers
        // put it to the CPU, time++
        // there are two scenarios,
        //      a) after a cycle (n tasks have been put into the CPU), resort.
        //      b) before a cycle reaches its end, tasks have been got from all of the categories. Thus
        //          use idle to fill CPU. time += number of idles
        //      resort.
        //      if all of the categories are empty, end.
        int time = 0;
        while(categories[25] > 0){
            int i = 25;
            while(categories[i] > 0){
                categories[i] --;
                time++;
                i--;
                if(25 - i == n + 1){
                    break;
                }
            }
            if(26 - i < n + 2 && categories[25]>0){
                time += n + 2 - (26-i);
            }
            Arrays.sort(categories);
        }
        return time;
    }
}
