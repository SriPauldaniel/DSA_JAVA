import java.util.*;
public class SinglyLinkedList {
    //creating a Structure of node...
    public static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }   

    //Creating linked list by adding nodes ...
    static Node head = null,tail = null;
    public static class LinkedList {
        LinkedList(int num) {
            Node newNode = new Node(num);
            if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        }
    }

    // Insering the node at specific index ...
    static Node insertMiddle(int pos,int val) {
        Node h = head;
        Node newNode = new Node(val);
        if(pos == 0) {
            newNode.next = head;
            return newNode;
        } else if(pos == length()-1) {
            tail.next = newNode;
            tail = tail.next;
        } else {
            while(pos != 1) {
            head = head.next;
            pos--;
            }
            Node temp = head.next;
            head.next = newNode;
            newNode.next = temp;
        }
        return h;
    }

    //get a value of specific index ...
    public static Node getValue(int index) {
        if(index < 0 || index >= length()) {
            return null;
        }
        Node temp = head;
        while(index != 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    
    // Calculating the length of the linked list...
    public static int length() {
        int length = 0;
        Node h = head;
        while(h != null) {
            h= h.next;
            length++;
        }
        return length;
    }

    //removing an element from specific index....
    static void removeIndex(int pos) {
        Node h = head;
        if(head == null) {
            System.out.println("Error Empty Linked List");
        } else if(pos == 0) {
            head = head.next;
            h.next = null;
        } else if(pos == length()-1) {
            while(pos != 1) {
                h = h.next;
                pos--;
            }
            h.next = null;
            tail = h;
        } else {
            while(pos != 1) {
                h = h.next;
                pos--;
            }
            Node temp = h;
            h = h.next.next;
            temp.next = h;
        }
    }

    //Updating a value of a linked list...
    static void setValue(int pos,int val) {
        if(head != null) {
            getValue(pos).data = val;
        }
    }


    //Displaying the elements of Linked List...
    static void displayList(Node head) {
        Node h = head;
        while(h != null) {
            System.out.print(h.data+" ");
            h = h.next;
        }
    }

    //Main method calling functions of all the operations...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(),num;
        for(int i=0;i<n;i++) {
            num = sc.nextInt();
            LinkedList linkedlist = new LinkedList(num);
        }
        displayList(head);
        displayList(head);
        System.out.println(getValue(3).data);
        
        int pos = sc.nextInt();
        int val = sc.nextInt();
        setValue(pos, val);
        displayList(head);
        sc.close();
    }
}