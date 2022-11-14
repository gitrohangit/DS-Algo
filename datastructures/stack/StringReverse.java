package datastructures.stack;

import java.util.Stack;

public class StringReverse {
	
	public static void reverse(String str) {
		Stack<Character> stack = new Stack<>();
		char[] ch = str.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			stack.push(ch[i]);
		}
		
		while (!stack.empty()) {
			System.out.print(stack.pop());
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse("rohan");
	}

}
