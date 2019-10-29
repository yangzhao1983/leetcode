package zy.leetcode;


/**
 * Created by kaiser_zhao on 29/04/2019.
 */
public class Solution25 {

    public static void main(String...strings){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printListNode(reverseKGroup(n1, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k){

        if(k == 1){
            return head;
        }

        // Assuming k > 1
        // Add dummy head
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode nextHead = getNextHead(dummyHead, k);
        ListNode curHead = dummyHead;

        ListNode nextStart = null;
        while(nextHead!=null){
            nextStart = nextHead.next;
            curHead = doReverseKthGroup(curHead, k);
            curHead.next = nextStart;
            nextHead = getNextHead(curHead, k);
        }

        return dummyHead.next;
    }

    public static void printListNode(ListNode lns){

        while(lns!=null){
            System.out.println(lns.val);
            lns = lns.next;
        }
    }

    /**
     * save nodek+1, nextHead.next
     *
     * head->node1->node2->..->nodek->nodek+1
     * ====>
     * head->node2->node1->..->nodek->nodek+1
     * ====>
     * head->node3->node2->node1->..->nodek->nodek+1
     * ....====>
     * head->nodek->nodek-1->..->node1 nodek+1
     *
     *
     * head->nodek
     * return node1
     *
     * @param head
     * @param k
     * @return nodek
     */
    public static ListNode doReverseKthGroup(ListNode head, int k){
        ListNode first = head.next;
        ListNode cur = first.next;
        ListNode nextCur = null;
        ListNode lastFirst = first;
        for(int i = 0; i<k-1;i++){
            lastFirst = head.next;
            head.next = cur;
            nextCur = cur.next;
            cur.next = lastFirst;
            cur = nextCur;
        }
        return first;
    }

    /**
     * head->node1->node2->..->nodek->nodek+1
     *
     * return nodek
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getNextHead(ListNode head, int k){
        if (head == null){
            return null;
        }else{
            int numOfNodeInPhase = 0;
            ListNode precedingNode = head;
            while(head!=null && numOfNodeInPhase < k){
                precedingNode = head;
                head = head.next;
                numOfNodeInPhase ++;
            }
            if (numOfNodeInPhase < k){
                return null;
            }else{
                return head;
            }
        }
    }
}
