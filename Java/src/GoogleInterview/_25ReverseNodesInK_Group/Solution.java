package GoogleInterview._25ReverseNodesInK_Group;

class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }
 }


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <=0){
            return null;
        }

        ListNode start = head;
        int index = k;
        ListNode end = head;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;

        index = 0;
        ListNode dummy = new ListNode(0);

        while(end!=null && index < k){
            end = end.next;
            index++;
        }

        while(index == k){

//reverse. while not equal to end

            ListNode futureTail = start;

            while(start!=end){
                ListNode tmp = start;
                start = start.next;
                tmp.next = dummy.next;
                dummy.next = tmp;
            }

            newTail.next = dummy.next;
            newTail = futureTail;

            index = 0;
            dummy = new ListNode(0);

            while(end!=null && index < k){
                end = end.next;
                index++;
            }
        }

        newTail.next = start;
        return newHead.next;

    }
}


