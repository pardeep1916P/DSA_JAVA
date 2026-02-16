package src.ll.concept;

public class LinkedList{

    private Node head;
    private Node tail;
    private int length;
    
    //ll constructor
    public LinkedList(int value){
        Node newNode =new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    
    //print list
    public void printList(){
        if(head==null){
            System.out.println("Empty");
        }
        Node temp=head;

        while(temp!= null){
            System.out.print(temp.value);
            if(temp!=tail){
                System.out.print("->");
            }
            temp=temp.next;
        }
        System.out.println();
    }
    
    //print head value
    public void getHead(){
        if (head==null) {
            System.out.println("Empty");
        }else{
            System.out.println("Head :" + head.value);
        }
    }
    
    //print tail value
    public void getTail(){
        if (tail==null) {
            System.out.println("Empty");
        }else{
            System.out.println("Tail :" + tail.value);
        }
    }
    
    //print length
    public void getLength(){
            System.out.println("Length :" + length);
    }
    
    //append a value (add at last) using tail
    public void append(int value){
        Node newNode =new Node(value);
        if(head==null){
            head = newNode;
            tail = newNode;
        } else{
            tail.next=newNode;
            tail=tail.next;
        }
        length++;
    }

    //append a value (add at last) without using tail
    public void append_without_tail(int value){
        Node newNode = new Node(value);
        if( head ==null){
            head=newNode;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
        length++;
    }

    //prepend a value (add at first)
    public void prepend(int value){
        Node newNode =new Node(value);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        length++;
    }

    //remove first node
    public Node removeFirst(){
        Node temp=head;
        if(head==null) return null;
        else if (head == tail) {
            head=null;
            tail=null;
        }else{
            head=head.next;
            temp.next=null;
        }
        length--;
        return temp;
    }

    //remove last node
    public Node removeLast(){
        Node temp=head;
        if(head==null){
            return null;
        } else if (head==tail) {
            head=null;
            tail=null;
        }else{
            while(temp.next!=tail){
                temp=temp.next;
            }
            tail=temp;
            temp=temp.next;
            tail.next=null;
        }
        length--;
        return temp;
    }

    // get node by index
    public Node get(int index){
        if(index<0 || index>length) return null;
        Node temp= head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    //set value at an index
    public boolean set(int index,int value){
        Node temp= get(index);
        if (temp!=null){
            temp.value=value;
            return true;
        }
        return false;
    }

    //insert at an index
    public boolean insert(int index,int value){
        if(index<0 || index > length){
            return false;
        }if(index==0){
            prepend(value);
            return true;
        }if(index==length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length++;
        return true;
    }

    //remove at an index
    public Node remove(int index){
        if(index<0 || index > length) return null;
        if(index==0) return removeFirst();
        if(index==length) return removeLast();
        Node prev=get(index-1);
        Node temp=prev.next;
        prev.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }

    //reverse
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        while(temp!=null){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }

    //getMiddle
    public Node getMiddle(){
        if(head==null) return null;
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}