package src.ll.problems;

static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    if(head==null) return newNode;
    SinglyLinkedListNode tail= head;
    while(tail.next!=null) tail=tail.next;
    tail.next=newNode;
    // tail=tail.next;
    return head;
}