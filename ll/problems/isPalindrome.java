package src.ll.problems;

public boolean isPalindrome(ListNode head) {
    if(head==null || head.next==null) return true;
    //find middle node of ll
    ListNode fast=head,slow=head;
    while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode head2 = reverse(slow.next);//reverse the second half
    //compare the reversed second half with first half
    while(head2!= null){
        if(head.val!= head2.val) return false; //if the values does not matches
        head=head.next;
        head2=head2.next;
    }
    return true;
}

//helper method to reverse the list from the pointer head
public ListNode reverse(ListNode head){
    ListNode prev=null,temp=head;
    while(temp != null){
        ListNode curr=temp.next;
        temp.next=prev;
        prev=temp;
        temp=curr;
    }
    return prev;
}
