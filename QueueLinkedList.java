import java.util.*;
public class QueueLinkedList {
    //Creating the structure of the node
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    static Node first = null,last = null;
    static int length = 0;

    //Enqueue method in the last of LinkedList for O(1) time complexity
    static void enqueue(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            first = newNode;
            last = newNode;

        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
        System.out.println("\nElement added to the Queue...");
    }
    //Dequeue method in First of LinkedList for O(1) time complexity
    static Node dequeue() {
        if(length == 0) {
            return null;
        }
        Node temp = first;
        if(length == 1) {
            first = last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    //Displaying the queue from the first
    static void display() {
        Node temp = first;
        System.out.print("Displaying the Queue -->");
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    //Case condition for all the Queue Operations...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("\n 1-->Add an Element \n 2-->Remove an Element \n 3-->Display Queue \n 4--> Get Details \n 5-->exit ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print(" Enter the number : ");
                    int num = sc.nextInt();
                    System.out.println("adding........");
                    enqueue(num);
                    break;
                case 2:
                    System.out.println("Deleting element form Queue...");
                    System.out.println(dequeue().value);
                    break;
                case 3:
                    if(first == null) {
                        System.out.println("Queue is empty !!!!!!");
                    } else {
                        display();
                    }
                    break;
                case 4:
                    if(first == null) {
                        System.out.println("Queue is empty !!!!!");
                    } else {
                        System.out.println(" First : " + first.value);
                        System.out.println(" Last : "+ last.value);
                        System.out.println("Length : "+length);
                        display();
                    }
                    
                    break;
                case 5:
                    System.out.println("Operations Executed.....");
                    flag = false;
                    break;
            }
        }
        sc.close();
    }
}