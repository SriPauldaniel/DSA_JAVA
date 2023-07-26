import java.util.*;
public class LinkedList {
    public static class Node {
        int data;
        Node next;
        Node(int val) {
            data = val;
            next = null;
        }
    }

    static Node head = null,tail = null;
    public static class List {
        List(int val) {
            Node newNode = new Node(val);
            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
    }


    static void display() {
        Node temp = head;
        System.out.println("\nDisplaying Linked List =>>");
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static int length = 0;
    static void length() {
        Node temp = head;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }
        if(temp.next == null) {
                length++;
        }
        System.out.println("\nlength of list : "+ length);
    }  
    static void reverse() {
        Node h = head;
        head = tail;
        tail = head;
        
        Node before = null,after = head.next;
        while(h != null) {
            after = h.next;
            h.next = before;
            before = h;
            h = after;
        }
        System.out.println("\nLinked List reversed");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = 0;
        while(true) {
            val = sc.nextInt();
            if(val == 111) {
                break;
            }
            List list = new List(val);
        }
        display();
        length();
        reverse();
        display();
        sc.close();
    }
}
