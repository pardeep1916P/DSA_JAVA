package src.ll.problems;

public ListNode detectCycle(ListNode head) {
    if(head==null || head.next==null) return null; //base case empty list
    ListNode fast = head;
    ListNode slow = head;
    //detect if loop exist
    while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow) break;
    }
    //extra check if loop doesn't exist
    if(fast==null || fast.next==null) return null;
    //to find exact node where loop begins
    slow = head;
    while(slow!=fast){
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}