import java.util.*;
public class DoublyLinkedList {

    //----------------------------------------------------- Creation of List and Nodes ----------------------------------------------------------------------
    
    //creating the nodes ...
    public static class Node {
        int data;
        Node prev,next;
        Node(int val) {
            data = val;
            prev = next = null;
        }
    }

    //Creating a linked list ...
    static Node head = null,tail = null;
    static int length = 0;
    public static class List {
        List(int val) {
            Node newNode = new Node(val);
            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = tail.next;
            }
            length++;
        }
    }
    //------------------------------------------Insertion----------------------------------------------------------------

    //Inserting an element at the first ... 
    static void prepend(Node newNode) {
        newNode.next = head;
        head.prev = newNode;
        head = head.prev;
    }

    //Insertind an element at the end ... 
    static void append(Node newNode) {
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
    }


    //Inserting an element at certail index
    static void insertAtIndex(int pos,int value) {
        Node newNode = new Node(value);
        if(pos == 0) {
            prepend(newNode);
        } else if(pos == length-1) {
            append(newNode);
        } else {
            Node temp = head;
            while(pos != 1) {
                temp = temp.next;
                pos--;
            }
            newNode.next = temp.next;
            newNode.prev= temp;
            newNode.next.prev = newNode;
            temp.next = newNode;
        }
        System.out.println("Element Inserted in the List...");
    }

    //--------------------------------------------------------Deletion--------------------------------------------------------------------

    //remove Element at first index ...
    static void deleteFirst() {
        Node h = head;
        head = head.next;
        h.next = null;
        head.prev = null;
        length--;
    }

    //remove Element at the Last index ...
    static void deleteLast() {
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
    }

    //remove Element at specific index ... 
    static void removeIndex(int pos) {
        if(pos == 0) {
            deleteFirst();
        } else if(pos == length-1) {
            deleteLast();
        } else {
            if(pos > length/2) {
                Node h = tail;
                int i = length;
                while(i != pos) {
                    h = h.prev;
                    i--;
                }
                Node before = h.prev;
                before.next = h.next;
                h.next.prev = before;
                h.prev = h.next = null;
                length--;
            } else {
                Node h = head;
                while(pos != 1) {
                    h = h.next;
                    pos--;
                }
                Node temp = h.next;
                h.next = temp.next;
                temp.next.prev = h;
                temp.next = temp.prev = null;
                length--;
            }
        }
        System.out.println("Element removed from List");
    }

    //--------------------------------------------------------------------Updation-------------------------------------------------------------------------

    //Updating the value at specific Position
    static void setValue(int pos,int value) {
        if(pos > length/2) {
            Node h = tail;
            int i = length;
            while(i != pos) {
                h = h.prev;
                i--;
            }
            h.data = value;
        } else {
            Node h = head;
            while(pos != 0) {
                h = h.next;
                pos--;
            }
            h.data = value;
        }
    }

    //--------------------------------------------------------Searching--------------------------------------------------------------------------------------

    //returning the element at specified index ..
    static void searchIndex(int pos) {
        if(pos > length-1) {
            Node temp = tail;
            int i = length -1;
            while(i != pos) {
                temp = temp.prev;
                i--;
            }
            System.out.println(temp.data);
        } else {
            Node temp = head;
            while(pos != 0) {
                temp = temp.next;
                pos--;
            }
            System.out.println(temp.data);
        }
    }

    //Search an element present in the List ...
    static void searchElement(int value) {
        int i=0,flag = 0;;
        Node temp = head;
        while(i < length) {
            if(temp.data == value) {
                System.out.println("Value : "+temp.data + "  Index : "+ i);
                flag = 1;
                break;
            }
            temp = temp.next;
            i++;
        }
        if(flag == 0) {
            System.out.println("Value not found");
        }
    }

    //----------------------------------------------------------Display--------------------------------------------------------------------------------------

    //Displaying the Linked List ...
    static void display() {
        Node h = head;
        System.out.print("Displaying the value --> ");
        while(h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println("\n");
    }

    //--------------------------------------------------------------Main Method-------------------------------------------------------------------------------
    
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int num;
        while(true) {
            num = sc.nextInt();
            if(num == 00) {
                break;
            }
            List list = new List(num);
        }

        removeIndex(2);
        display();
        insertAtIndex(4, 0);
        display();
        setValue(2,3);
        setValue(3, 4);
        setValue(4,5);
        display();
        searchIndex(2);
        searchElement(6);

        sc.close();
    }
}
