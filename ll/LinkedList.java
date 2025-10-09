package src.ll;

public class LinkedList{
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
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

}