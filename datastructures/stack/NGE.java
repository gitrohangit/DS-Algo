package datastructures.stack;

import java.awt.DisplayMode;
import java.util.Stack;

public class NGE {

	public static int[] nextGreaterElem(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for(int i = arr.length-1 ; i >= 0; i--) {
			if(!st.isEmpty()) {
				while(!st.isEmpty() && arr[i] >= st.peek()) {
					st.pop();
				}
				if(st.isEmpty()) {
					result[i] = -1;
				}
				else {
					result[i] = st.peek();
				}
			}
			else {
				result[i] = -1;
			}
			
			st.push(arr[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1 , 9 , 3 , 22 , 7 , 65};
		Display(arr);
		System.out.println("NGE");
		Display(nextGreaterElem(arr));
	}

	private static void Display(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
