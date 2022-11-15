package datastructures.stack;

import java.util.Iterator;
import java.util.Stack;

public class validParentheses {

	public static boolean isValid(String str) {
		Stack<Character> stack  = new Stack<>();
		for(char c : str.toCharArray()) {
			if(c == '{' || c == '(' || c == '[') {
				stack.push(c);
			}else {
				if(stack.isEmpty()) {
					return false;
				}else {
					char top = stack.peek();
					if(top == '[' && c == ']' ||
							top == '{' && c == '}' ||
							top == '(' && c == ')') {
						stack.pop();
					}else {
						return false;
					}
				}			
			}
		}
		return stack.isEmpty();
	}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			validParentheses obj = new validParentheses();
			String[] input = {"{([])}","{([}","{([)]}","()"};
	
			for(String s : input) {
				
				System.out.println(s + " : " + (obj.isValid(s) ? "Valid" : "Not Valid"));
			}
			
		}

	}
