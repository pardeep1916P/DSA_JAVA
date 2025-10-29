package src.ll.problems;

//helper method to merge two sorted linked lists
public ListNode merge(ListNode l1,ListNode l2){
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while(l1 != null && l2 != null){
        if(l1.val <= l2.val){
            curr.next = l1;
            l1 = l1.next;
        }else{
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    if(l1 != null) curr.next = l1;
    if(l2 != null) curr.next = l2;
    return dummy.next;
}

//helper method to find mid of a given list
public ListNode getMid(ListNode head){
    ListNode fast = head,slow = head,prev = null;
    while(fast != null && fast.next != null){
        prev = slow;
        fast = fast.next.next;
        slow = slow.next;
    }
    return prev;
}
public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) return head;

    // split list into two equal halfs
    ListNode left = head;
    ListNode right = getMid(head);
    ListNode temp = right.next;
    right.next = null;
    right = temp;

    // recursive call
    left = sortList(left);
    right = sortList(right);

    return merge(left,right);
}