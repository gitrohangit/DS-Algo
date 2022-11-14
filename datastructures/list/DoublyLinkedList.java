package datastructures.list;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length;
	
	private class ListNode {
		private int data;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int data) {
			this.data = data;
		}	
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0; //head == null
	}
	
	public int length() {
		return length;
	}
	
	public void displayForward(ListNode head) {
		ListNode temp = head;
		while(temp !=  null) {
			System.out.print(temp.data + " -->");
			temp = temp.next;
		}
		
		System.out.println("null");
	}
	
	public void displayBackward(ListNode tail) {
		ListNode temp = tail;
		while(temp !=  null) {
			System.out.print(temp.data + " -->");
			temp = temp.previous;
		}
		
		System.out.println("null");
	}
	
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		
		if(isEmpty()) {
			head = newNode;
		}
		else {
			tail.next = newNode;
		}
		newNode.previous = tail;
		tail = newNode;
		length++;
	}
	
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		
		if(isEmpty()) {
			tail = newNode;
		}
		else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = head;
		
		if(head == tail) {
			tail = null;
		}else {
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null; 
		length--;
		return temp;
	}
	
	public ListNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = tail;
		
		if(head == tail) {
			head = null;
		}else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null; 
		length--;
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertLast(1);
		dll.insertLast(10);
		dll.insertLast(15);
		dll.insertLast(25);
 		
		dll.insertFirst(45);
		dll.insertFirst(12);
		dll.insertFirst(8);
		dll.insertFirst(50);
		
		System.out.println("First element removed of linked list: " + dll.deleteFirst().data);
		System.out.println("Last element removed of linked list: " + dll.deleteLast().data);
		
		dll.displayForward(dll.head);
		dll.displayBackward(dll.tail);
		
	}

}
