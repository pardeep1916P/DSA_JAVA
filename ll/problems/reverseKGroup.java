package src.ll.problems;

public ListNode reverseKGroup(ListNode head, int k) {
    if(head==null || k==1) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevGroupEnd = dummy;
    while(true){
        ListNode kth = getKthNode(prevGroupEnd,k);
        if(kth == null) break;

        ListNode groupStart = prevGroupEnd.next;
        ListNode nextGroupStart = kth.next;

        //reverse k nodes
        reverse(groupStart,kth);

        //connecting the reversed part in same place
        prevGroupEnd.next = kth;
        groupStart.next = nextGroupStart;

        prevGroupEnd = groupStart;
    }
    return dummy.next;
}

//helper method for kth node from the start
private ListNode getKthNode(ListNode start,int k){
    while(start != null && k > 0){
        start = start.next;
        k--;
    }
    return start;
}

//helper method to reverse from start to end
private void reverse(ListNode start,ListNode end){
    ListNode prev = null;
    ListNode curr = start;
    ListNode stop = end.next;
    while(curr != stop){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
}