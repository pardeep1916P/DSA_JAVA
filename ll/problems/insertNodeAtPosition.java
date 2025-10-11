package src.ll.problems;

//helper method if pos=last
public static SinglyLinkedListNode append(SinglyLinkedListNode head,int data){
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    if(head == null) head=newNode;
    else{
        SinglyLinkedListNode temp=head;
        while(temp.next!=null) temp=temp.next;
        temp.next=newNode;
    }
    return head;
}

//helper method if pos=first
public static SinglyLinkedListNode prepend(SinglyLinkedListNode head,int data){
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    if(head==null) head=newNode;
    else{
        newNode.next=head;
        head=newNode;
    }
    return head;
}

//helper method to get size of the ll
public static int getSize(SinglyLinkedListNode head){
    if(head==null) return 0;
    SinglyLinkedListNode temp=head;
    int count=0;
    while(temp!=null){
        count++;
        temp=temp.next;
    }
    return count;
}

public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    int size =getSize(llist);
    if(position<0 || position>size) return null;
    else if(position==0) return prepend(llist,data);
    else if(position==size) return append(llist,data);
    else{
        SinglyLinkedListNode newNode=new SinglyLinkedListNode(data);
        SinglyLinkedListNode temp=llist;
        for(int i=0;i<position-1;i++) temp=temp.next;
        newNode.next=temp.next;
        temp.next=newNode;
    }
    return llist;
}
