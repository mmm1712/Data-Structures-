import java.util.*;
public class HW3_1 {
    public static void main(String[] args) {
        
        Node node = new Node(1);
        Node current = node;
		
		Scanner sc = new Scanner(System.in);
        System.out.println("enter total count of elements -> ");
        int num = sc.nextInt();
        if (num<52) {
		for(int i = 1; i < num; i++) {
			current.next = new Node(i+1);
			current = current.next;
		} 
		
        Solution sol = new Solution();
        
        System.out.println("Non-homogenized numbers:");
        printList(node);
		sol.mixList(node);
		System.out.println("Homogenized numbers:");
		printList(node);
		
    } else {

         System.out.println("Number is too big ");
    }
}
   
    public static void printList(Node head) {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val + "->null");
    }
}
class Node {
    int val;
    Node next;
    Node(int x) {
        val = x;
    }
}

/**
 * PURPOSE: mixList(Node head) transforms any non-homogeneous list into a homogeneous list 
 * PARAMETERS: Node head 
 * RETURN VALUES: Non-homogeneous List and Homogeneous List
 */
 
class Solution {

	public void mixList(Node head) {
		Node current = head;
		Node first = head;
		Node second = current.next;

		while (second != null && second.next != null) {
			current = current.next;
			second = second.next.next;
		}
		
	    Node new_node = current.next;
	    
		Node prev = null;
		Node next = null;
		while (new_node != null) {
		    next = new_node.next;
			new_node.next = prev;
			prev = new_node;
			new_node = next;
		}
		new_node = prev;
		
		head = new Node(0);
		current.next = null;
		current = head;

		while (first != null || new_node != null) {
			if (first != null) {
				current.next = first;
				current = current.next;
				first = first.next;
			}
			if (new_node != null) {
				current.next = new_node;
				current = current.next;
				new_node = new_node.next;
			}
		}
		head = head.next;
	}
}