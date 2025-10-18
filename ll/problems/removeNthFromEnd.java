package src.ll.problems;

public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head==null) return null;  //if list is null
    ListNode slow=head,fast=head;
    for(int i=0;i<n;i++) fast=fast.next; //distance between fast and slow is n
    if(fast==null) return head.next;    //if fast is null head is the nth node to be deleted
    while(fast!=null && fast.next!=null){
        fast=fast.next;
        slow=slow.next;
    }
    slow.next=slow.next.next; //slow is before nth node
    return head;
}