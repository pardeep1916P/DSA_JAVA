package src.ll.problems;

//helper method to reverse a linked list
public ListNode reverse(ListNode head){
    if(head==null) return head;
    ListNode before = null;
    ListNode temp = head;
    while(temp!=null){
        ListNode after = temp.next;
        temp.next = before;
        before = temp;
        temp = after;
    }
    return before;
}

//helpere method to find the mid of a ll
public ListNode getMid(ListNode head){
    if(head == null) return null;
    ListNode fast = head,slow = head;
    while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}
public void reorderList(ListNode head) {
    if(head==null) return;
    ListNode slow = getMid(head);
    ListNode start = slow.next;
    slow.next = null;
    start = reverse(start);
    ListNode first = head;
    //merging two lists in criss-cross
    while(start != null){
        ListNode temp1 = first.next,temp2 = start.next;
        first.next = start;
        start.next = temp1;
        first = temp1;
        start = temp2;
    }
}