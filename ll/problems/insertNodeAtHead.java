package src.ll.problems;

static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode newNode=new SinglyLinkedListNode(data);
    if(llist==null) return newNode;
    newNode.next=llist;
    llist=newNode;
    return llist;
}