/*输入两个链表，找出它们的第一个公共节点。*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //把A.length看成A+x
 //B.length=B+x
 //然后会有A+X+B=B+X+A,意思是分别从A,B开始遍历，遍历完之后
 //A换到B的头,B换到A的头即可
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        int flag=0;//标记变量，是否已经遍历过了两遍
        if(p1==null||p2==null)
            return null;
        while(p1!=p2&&flag!=2)
        {
            p1=p1.next;
            p2=p2.next;
            if(p1==null)
                {p1=headB;flag++;}
            if(p2==null)
                p2=headA;
        }
        if(p1==p2)
            return p1;
        else
            return null;
    }
}