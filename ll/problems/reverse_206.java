package src.ll.problems;

public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null) return head;
    ListNode before=null,temp=head;
    while(temp!=null){
        ListNode after=temp.next;
        temp.next=before;
        before=temp;
        temp=after;
    }
    return before;
}