package src.ll.problems;

public void removeDuplicates(){
    if(head==null) return;
    Node temp=head;
    while(temp!=null){
        Node pre=temp;
        while(pre.next!=null){
            if(pre.next.value == temp.value){
                pre.next=pre.next.next;
                length--; //no required for leetCode
            }else{
                pre=pre.next;
            }
        }
        temp=temp.next;
    }
}