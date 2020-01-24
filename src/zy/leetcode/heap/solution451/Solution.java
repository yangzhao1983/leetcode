package zy.leetcode.heap.solution451;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String frequencySort(String s){
        Map<Character, Integer> charNum = new HashMap<>();

        // transfer s to hash<char char, int num>
        for(Character c : s.toCharArray()){
            charNum.put(c, charNum.getOrDefault(c, 0) + 1);
        }

        Character[] heap = new Character[charNum.size()];
        int i = 0;
        for(Character c : charNum.keySet()){
            heap[i++] = c;
        }

        // put keys in hash to heap, sorted by num, shiftUp
        rearrangeHeap(heap, charNum);

        // keeping popping up items from heap, shiftDown
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < heap.length; j++){
            Character c = pop(heap, heap.length -j -  1, charNum);
            for(int k = 0; k < charNum.get(c); k++){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private Character pop(Character[] heap, int end, Map<Character, Integer> charNum){
        Character top = heap[0];
        heap[0] = heap[end];
        shiftDown(heap, 0, charNum, end-1);
        return top;
    }

    private void shiftUp(Character[] heap, int index, Map<Character, Integer> charNum){
        // if top, then return
        if(index == 0){
            return;
        }

        // get parent index
        int parentIndex = (index - 1)/2;
        if (charNum.get(heap[parentIndex]) < charNum.get(heap[index])){
            swap(heap, index, parentIndex);
            shiftUp(heap, parentIndex, charNum);
        }
    }

    private void rearrangeHeap(Character[] heap, Map<Character, Integer> charNum){
        for(int i = heap.length /2 -1; i>=0; i--){
            shiftDown(heap,i,charNum,heap.length-1);
        }
    }

    private void shiftDown(Character[] heap, int index, Map<Character, Integer> charNum, int endIndex){
        int childIndexLeft = index * 2 + 1;
        int childIndexRight = index * 2 + 2;

        if(childIndexLeft > endIndex){
            return;
        }else{
            if(charNum.get(heap[index]) < charNum.get(heap[childIndexLeft])){
                swap(heap, index, childIndexLeft);
                shiftDown(heap, childIndexLeft, charNum,endIndex);
            }
        }

        if(childIndexRight <= endIndex){
            if(charNum.get(heap[index]) < charNum.get(heap[childIndexRight])){
                swap(heap, index, childIndexRight);
                shiftDown(heap, childIndexRight, charNum,endIndex);
            }
        }

    }

    private void swap(Character[] heap, int from, int to){
        Character tmp = heap[from];
        heap[from] = heap[to];
        heap[to] = tmp;
    }

    private static void test1(){
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
    }

    private static void test2(){
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("ccaaa"));
    }

    private static void test3(){
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("Mymommaalwayssaid,\"Lifewaslikeaboxofchocolates.Youneverknowwhatyou'regonnaget."));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
    }
}
