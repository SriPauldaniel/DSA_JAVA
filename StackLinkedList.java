import java.util.*;
public class StackLinkedList {

    static  class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    static Node top;
    static int height;
    static class Stack {
        
        Stack(int value) {
            Node newNode = new Node(value);
            height++;
        }
    }

    static void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println("Element Pushed into stack...");
        height++;
    }

    static Node pop() {
        if(height == 0) {
            return null;
        } else if(height == 1) {
            top = null;
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
        }
        height--;
        System.out.println("Element popped");
        return top;
    }


    static void display() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("\n 1-->Push an Element \n 2-->Pop an Element \n 3-->Find the height \n 4-->display \n 5-->Get Details \n 6-->exit");
            int choise = sc.nextInt();
            switch(choise) {
                case 1:
                System.out.print("Enter a Number : ");
                int num = sc.nextInt(); 
                    push(num);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    System.out.println(" Height of the Stack " + height);
                    break;
                case 4:
                System.out.println("Printing Stack");
                    display();
                    break;
                case 5:
                    if(top == null) {
                        System.out.println("Stack is Empty");
                    } else {
                        System.out.println("Top : "+ top.value);
                        System.out.println("Printing Stack");
                        display();
                    }
                    break;  
                case 6:
                    flag = false;
                    System.out.println("Operations completed ");
                    break;
            }

        }
        sc.close();
    }
}