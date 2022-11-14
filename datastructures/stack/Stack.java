package datastructures.stack;

import java.util.EmptyStackException;

public class Stack {
	
	private ListNode top;
	private int length;
	
	private class ListNode{
		private ListNode next;
		private int data;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public Stack(){
		top = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	public void push(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = top;
		top = newNode;
		length++; 
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.data;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
	}

}
