package datastructures.list;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
	
	private ListNode last;
	private int length;
	
	private class ListNode{
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public CircularSinglyLinkedList() {
		last = null;
		length = 0;
	}
	
	public int length(){
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	private ListNode createCircularLinkedList(int n) {
		ListNode firstNode = new ListNode((int)(Math.random() * 10));
		length++;
		ListNode lastNode = firstNode;
		
		for(int i = 1; i < n; i++) {
			lastNode.next = new ListNode((int)(Math.random() * 10));
			lastNode = lastNode.next;
			length++;
		}
		
		lastNode.next = firstNode; 
		last = lastNode;
		
		return lastNode;
		
	}
	
	public void display(){
		if(last == null) {
			return;
		}
		
		ListNode first = last.next;
		while(first != last) {
			System.out.print(first.data+ " ");
			first = first.next;
		}
		System.out.print(first.data);
	}
	
	public void insertFirst(int data) {
		ListNode newNode = new ListNode(data);
		
		if(last == null) {
			last = newNode;
			last.next = last;
		}else {
			newNode.next = last.next;
		}
		last.next = newNode;
		length++;
	}
	
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = last.next;
		if(temp == last) {
			last = null;
		}else {
			last.next = temp.next;
		}
		temp.next = null;
		length--;
		return temp;
		
	}

	
	public void insertLast(int data) {
		ListNode newNode = new ListNode(data);
		
		if(last == null) {
			last = newNode;
			last.next = last;
		}else {
			newNode.next = last.next;
			last.next = newNode;
		}
		last = newNode;
		length++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
		csll.createCircularLinkedList(6);
		csll.insertFirst(25);
		csll.insertLast(33);
		csll.deleteFirst();
		csll.display();
	}

}
