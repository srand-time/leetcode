/*�������������ҳ����ǵĵ�һ�������ڵ㡣*/

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
 //��A.length����A+x
 //B.length=B+x
 //Ȼ�����A+X+B=B+X+A,��˼�Ƿֱ��A,B��ʼ������������֮��
 //A����B��ͷ,B����A��ͷ����
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        int flag=0;//��Ǳ������Ƿ��Ѿ�������������
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