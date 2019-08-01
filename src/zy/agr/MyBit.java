package zy.agr;

/**
 * Created by kaiser_zhao on 24/07/2019.
 */
public class MyBit {

    public static void main(String...strings){
        int[] origin = {3,2,0,6,5,-1,2};
        int[] bitArray = buildBIT(origin);
        for(int i = 0; i<bitArray.length; i++){
            System.out.println(bitArray[i]);
        }
        System.out.println("=========");
        for(int i = 0; i<bitArray.length; i++){
            System.out.println(searchSum(bitArray, i));
        }
    }

    private static int[] buildBIT(int[] origin){

        int[] bitArray = new int[origin.length + 1];

        for(int i = 0; i<bitArray.length; i++){
            bitArray[i] = 0;
        }

        for(int i = 1; i< bitArray.length; i++){
            updateBitArray(origin[i-1], i, bitArray);
        }

        return bitArray;
    }

    private static int searchSum(int[] bitArray, int cur){
        int sum = bitArray[cur];
        int parent = getParent(cur);
        while(parent > 0){
            sum += bitArray[parent];
            parent = getParent(parent);
        }
        return sum;
    }

    private static void updateBitArray(int valueDelta, int bitArrayPos, int[] bitArray){

        bitArray[bitArrayPos] += valueDelta;

        // get next position in bit array, change it
        int next = getNext(bitArrayPos);
        while(next < bitArray.length){
            bitArray[next] += valueDelta;
            next = getNext(next);
        }
    }

    private static int getNext(int cur){
        return cur + (cur & -cur);
    }

    private static int getParent(int cur){
        return cur - (cur & -cur);
    }
}
