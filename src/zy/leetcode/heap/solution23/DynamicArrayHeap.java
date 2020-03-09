package zy.leetcode.heap.solution23;

import zy.leetcode.linked.ListNode;

/**
 * Created by kaiser_zhao on 19/08/2019.
 */
public class DynamicArrayHeap {
    private static void testcase5(){
        ListNode node11 = new ListNode(-3);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(2);

        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(-9);

        ListNode node31 = new ListNode(-10);
        ListNode node32 = new ListNode(-5);
        ListNode node33 = new ListNode(-4);
        ListNode node34 = new ListNode(-2);
        ListNode node35 = new ListNode(-1);
        ListNode node36 = new ListNode(1);
        ListNode node37 = new ListNode(3);
        ListNode node38 = new ListNode(4);

        node31.next = node32;
        node32.next = node33;
        node33.next = node34;
        node34.next = node35;
        node35.next = node36;
        node36.next = node37;
        node37.next = node38;

        ListNode node41 = new ListNode(-10);
        ListNode node42 = new ListNode(-9);
        ListNode node43 = new ListNode(-8);
        ListNode node44 = new ListNode(3);
        ListNode node45 = new ListNode(4);

        node41.next = node42;
        node42.next = node43;
        node43.next = node44;
        node44.next = node45;

        ListNode node51 = new ListNode(-5);
        ListNode node52 = new ListNode(-3);
        ListNode node53 = new ListNode(3);
        ListNode node54 = new ListNode(4);

        node51.next = node52;
        node52.next = node53;
        node53.next = node54;

        ListNode node61 = new ListNode(-9);
        ListNode node62 = new ListNode(-8);
        ListNode node63 = new ListNode(-5);
        ListNode node64 = new ListNode(-4);
        ListNode node65 = new ListNode(-2);
        ListNode node66 = new ListNode(-1);
        ListNode node67 = new ListNode(3);

        node61.next = node62;
        node62.next = node63;
        node63.next = node64;
        node64.next = node65;
        node65.next = node66;
        node66.next = node67;

        ListNode[] lists = new ListNode[6];
        lists[0] = node11;
        lists[1] = node21;
        lists[2] = node31;
        lists[3] = node41;
        lists[4] = node51;
        lists[5] = node61;

        ListNode.outputAll(mergeKLists(lists));
    }

    private static void testcase4(){
        ListNode node11 = new ListNode(-8);
        ListNode node12 = new ListNode(-7);
        ListNode node13 = new ListNode(-7);
        ListNode node14 = new ListNode(-5);
        ListNode node15 = new ListNode(1);
        ListNode node16 = new ListNode(1);
        ListNode node17 = new ListNode(3);
        ListNode node18 = new ListNode(4);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        node17.next = node18;

        ListNode node21 = new ListNode(-2);

        ListNode node31 = new ListNode(-10);
        ListNode node32 = new ListNode(-10);
        ListNode node33 = new ListNode(-7);
        ListNode node34 = new ListNode(0);
        ListNode node35 = new ListNode(1);
        ListNode node36 = new ListNode(3);

        node31.next = node32;
        node32.next = node33;
        node33.next = node34;
        node34.next = node35;
        node35.next = node36;

        ListNode node41 = new ListNode(2);

        ListNode[] lists = new ListNode[4];
        lists[0] = node11;
        lists[1] = node21;
        lists[2] = node31;
        lists[3] = node41;

        ListNode.outputAll(mergeKLists(lists));
    }

    private static void testcase1(){
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);

        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);

        node21.next = node22;
        node22.next = node23;

        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);

        node31.next = node32;

        ListNode[] lists = new ListNode[3];
        lists[0] = node11;
        lists[1] = node21;
        lists[2] = node31;

        ListNode.outputAll(mergeKLists(lists));
    }

    private static void testcase2(){
        ListNode[] lists = new ListNode[2];
        lists[0] = null;
        lists[1] = null;
        ListNode.outputAll(mergeKLists(lists));
    }

    private static void testcase3(){

        ListNode node11 = new ListNode(1);

        ListNode node21 = new ListNode(0);

        ListNode[] lists = new ListNode[2];
        lists[0] = node11;
        lists[1] = node21;
        ListNode.outputAll(mergeKLists(lists));
    }

    public static void main(String...strings){
//        testcase1();
//        testcase2();
//        testcase3();
//        testcase4();
        testcase5();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        ListNode head = new ListNode(-1);
        ListNode curMergedList = head;

        // build min heap
        heapArray = new ListNode[lists.length];
        for(int i = 0; i< lists.length; i++){
            if(lists[i]!=null){
                addNodeToHeap(lists[i]);
            }
        }

        if(curEnd==-1){
            return null;
        }

        // loop start, until all of the k lists reach end
        while(true) {
            for(ListNode node: heapArray){
                System.out.print(node.val);
                System.out.print(',');
            }
            System.out.println();

            if(heapArray[0].val==-5){
                System.out.println("get it!");
            }

            // insert top to merged list
            curMergedList.next = heapArray[0];


            // remove top item from heap
            removeTopFromHeap();

            // insert top item to the heap if it exist.
            if(curMergedList.next.next != null){
                addNodeToHeap(curMergedList.next.next);
            }

            curMergedList = curMergedList.next;

            // loop end
            if(curEnd==-1){
                break;
            }
        }
        return head.next;
    }

    // build heap with array
    static ListNode[] heapArray;

    // current end of heap array
    static int curEnd = -1;

    private static void addNodeToHeap(ListNode node){
        // add node to the end of heap
        insertNodeToEnd(node);

        // shift up
        shiftUp(curEnd);

        shiftDown(0);
    }

    private static void removeTopFromHeap(){
        // swap top and end
        swapNode(0, curEnd);

        // remove end from heap
        curEnd--;

        // shift down top
        shiftDown(0);
    }

    /**
     * Swap nodes in heap array
     */
    private static void swapNode(int src, int obj){
        ListNode node = heapArray[src];
        heapArray[src] = heapArray[obj];
        heapArray[obj] = node;
    }

    private static void shiftDown2(int curIndex){
        int childIndexLeft = curIndex * 2 + 1;
        int childIndexRight = curIndex * 2 + 2;

        if(childIndexLeft > curEnd){
            return;
        }else{
            int indexToBeCompared = childIndexLeft;
            if(childIndexRight <= curEnd && heapArray[childIndexLeft].val > heapArray[childIndexRight].val){
                indexToBeCompared = childIndexRight;
            }

            if(heapArray[curIndex].val > heapArray[indexToBeCompared].val){
                swapNode(curIndex, indexToBeCompared);
                shiftDown2(indexToBeCompared);
            }
        }
    }

    /**
     * shift down current node.
     * If child is null, stop
     * If child is not null,
     *  if node.val > child.val, shift down.
     *  else stop
     */
    private static void shiftDown(int curIndex){
        int childIndexLeft = curIndex * 2 + 1;
        int childIndexRight = curIndex * 2 + 2;

        if(childIndexLeft > curEnd){
            return;
        }else{
            if(heapArray[curIndex].val > heapArray[childIndexLeft].val){
                swapNode(curIndex, childIndexLeft);
                shiftDown(childIndexLeft);
            }
        }

        if(childIndexRight <= curEnd){
            if(heapArray[curIndex].val > heapArray[childIndexRight].val){
                swapNode(curIndex, childIndexRight);
                shiftDown(childIndexRight);
            }
        }
    }

    /**
     * shift up current node.
     * If parent is null, stop
     * If parent is not null,
     *  if node.val < parent.val, shift up.
     *  else stop
     */
    private static void shiftUp(int curIndex){
        int parentIndex = (curIndex-1)/2;
        if(parentIndex < 0){
            return;
        }else{
            if(heapArray[curIndex].val < heapArray[parentIndex].val){
                swapNode(curIndex, parentIndex);
                shiftUp(parentIndex);
            }else{
                return;
            }
        }
    }

    private static void insertNodeToEnd(ListNode node){
        heapArray[++curEnd] = node;
    }
}
