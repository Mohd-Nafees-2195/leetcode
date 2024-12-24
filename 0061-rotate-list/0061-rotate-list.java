/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int n=0,i=1;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        if(head==null||k==0||n==k)
         return head;
        k=k%n;
        temp=head;
        while(i<n-k){
            temp=temp.next;
            i++;
        }
        ListNode newHead=null;
        if(temp.next!=null)
         newHead=temp.next;
        else
         newHead=temp;
        temp.next=null;
        temp=newHead;
        while(temp!=null&&temp.next!=null){
            temp=temp.next;
        }
        if(temp!=null)
         temp.next=head;
        return newHead;
    }
}