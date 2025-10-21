package src.ll.problems;

public ListNode[] splitListToParts(ListNode head, int k) {

    //step1-finding length
    ListNode temp = head;
    int length = 0;
    while(temp!=null){
        temp=temp.next;
        length++;
    }

    //step2- finding split length and remainder
    int partSize = length/k;
    int remainder = length%k;

    //step3-initialize array of size k stores head nodes of parts
    ListNode[] result = new ListNode[k];
    temp=head;

    //step4- splitting
    for(int i=0 ; i<k ; i++){
        ListNode partHead = temp;
        int currentParseSize = partSize + (i < remainder ? 1 : 0); //populating extra node if any exist
        for(int j=0 ; j<currentParseSize-1 ; j++) if(temp != null) temp = temp.next;
        //handles next part after splitting
        if(temp != null){
            ListNode nextPart = temp.next;
            temp.next = null;
            temp = nextPart;
        }
        //now the list is splitted and partHead is at the head of splitted List
        //adding that to the Node array
        result[i] = partHead;
    }

    return result;
}