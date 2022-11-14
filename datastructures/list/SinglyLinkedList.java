package datastructures.list;


public class SinglyLinkedList {
	
	private ListNode head;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		ListNode(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	
	public int length(){
		if(head == null) {
			return 0;
		}
		else {
			ListNode current = head;
			int count = 0;
			while(current != null) {
				count++;
				current = current.next;
			}
			
			return count;
		}
	}
	
	public void display() {
		ListNode currListNode = head;
		
		while(currListNode != null) {
			System.out.print(currListNode.data + "->");
			currListNode = currListNode.next;
		}
		System.err.println("null");
	}
	
	public void display(ListNode head) {
		ListNode currListNode = head;
		
		while(currListNode != null) {
			System.out.print(currListNode.data + "->");
			currListNode = currListNode.next;
		}
		System.err.println("null");
	}
	
	public ListNode deleteFirst() {
		if(head == null) {
			return null;
		}
		
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;		
	}
	
	public ListNode deleteLast() {
		if(head == null || head.next == null)
			return null;
		
		ListNode curr = head;
		ListNode previous = null;
		
		while(curr.next != null) {
			previous = curr;
			curr = curr.next;
		}
		
		previous.next = null;
		return curr;
	}
	
	public void deleteAt(int pos) {
		if(pos == 1) {
			head = head.next;
		}else {
			int count = 1;
			ListNode previous = head;
			while(previous != null && count < pos-1) {
				System.out.println(previous.data);
				previous = previous.next;
				count++;
			}
			previous.next = previous.next.next;
		}
	}
	
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if(head == null) {
			head = newNode;
		}
		else {
			ListNode current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
	public void insertAt(int value, int pos) {
		ListNode newNode = new ListNode(value);
		if(pos == 1) {
			newNode.next = head;
			head = newNode;
		}else {
			ListNode previousListNode = null;
			int count = 1;
			ListNode current = head;
			while(current != null && count < pos) { 
				previousListNode = current;
				current = current.next;
				count++;
			}
			previousListNode.next = newNode;
			newNode.next = current;
		}
			
	}

	public boolean find(int searchKey) {
		if(head == null) {
			return false;
		}
		ListNode currListNode = head;
		while(currListNode != null) {
			if(currListNode.data == searchKey) {
				return true;
			}
			currListNode = currListNode.next;
		}
		return false;
	}
	
	public ListNode reverseList() {
		if(head == null){
            return null;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null){
        	next = current.next;
        	current.next = previous;
        	previous = current;
        	current = next;
        }

        return previous;
	}
		
	public ListNode getMiddleNode() {
		if(head == null)
			return null;
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		return slowPtr;
	}

	public ListNode getNodeFromEnd(int n) {
		if(head == null)
			return null;
		
		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}
		
		ListNode mainPtr = head;
		ListNode fastPtr = head;
		int count = 1;
		
		while(count <= n) {
			if(fastPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in the list");
			}
			fastPtr = fastPtr.next;
			count++;
		}
		
		while(fastPtr != null) {
			mainPtr = mainPtr.next;
			fastPtr = fastPtr.next;
		}
		
		return mainPtr;
	}

	//given the list is sorted
	public void removeDuplicate() {
		if(head == null)
			return;
		
		ListNode currentNode = head;
		while(currentNode != null && currentNode.next != null) {
			if(currentNode.data == currentNode.next.data) {
				currentNode.next = currentNode.next.next;
			}else {
				currentNode = currentNode.next;	
			}
		}
	}
	
	//given the list is sorted
	public void insertInSortedList(int data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		ListNode curr = head;
		ListNode temp = head;
		
		while(curr != null && curr.data < data) {
			temp = curr;
			curr = curr.next;
		}
		temp.next = newNode;
		newNode.next =curr;
		
	}
	
	public void deleteNode(int key) {
		ListNode curr = head;
		ListNode prev = null;
		
		if(curr != null && curr.data == key) {
			head = curr.next;
			return;
		}
		
		while(curr != null && curr.data != key) {
			prev = curr;
			curr = curr.next;
		}
		
		if(curr ==  null) {
			return;
		}
		
		prev.next = curr.next;
	}
	
	public boolean containsLoop() {
		if(head == null) {
			return false;
		}
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(slowPtr == fastPtr) {
				return true;
			}
		}
		
		return false;
	}
	
	private ListNode createLinkedList(int n) {
		ListNode newNode = new ListNode(0);
		ListNode temp = newNode;
		
		for(int i = 0; i < n; i++) {
			temp.next = new ListNode((int)(Math.random() * 10));
			temp = temp.next;
		}
		
		display(newNode.next);
		
		return newNode.next;
	}
	private void createLoopInLL() {
		// TODO Auto-generated method stub
		ListNode firstNode = new ListNode(1);
		ListNode secondNode = new ListNode(2);
		ListNode thirdNode = new ListNode(3);
		ListNode fourthNode = new ListNode(4);
		ListNode fifthNode = new ListNode(5);
		ListNode sixthNode = new ListNode(6);
		
		head = firstNode;
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		fourthNode.next = fifthNode;
		fifthNode.next = sixthNode;
		sixthNode.next = thirdNode;
	}
	
	public ListNode startNodeInLoop() {
		if(head == null) {
			return null;
		}
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		ListNode start = null;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(slowPtr == fastPtr) {
				start =  getStartNode(slowPtr);
				removeLoop(slowPtr);
			}
		}
		
		return start;
	}
	
	
	private void removeLoop(ListNode slowPtr) {
		ListNode temp = head;
		
		while(temp.next != slowPtr.next) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		
		slowPtr.next = null;
	}

	private ListNode getStartNode(ListNode slowPtr) {
		ListNode temp = head;
		
		while(temp != slowPtr) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		
		return slowPtr;
	}
	
	public ListNode mergeSortList(ListNode head1,ListNode head2) {
		if(head2 == null && head1 == null) {
			return null;
		}
		else if (head2 == null) {
			return head1;
		}else if (head1 == null) {
			return head2;
		}
		
		ListNode ptr1 = head1;
		ListNode ptr2 = head2;
		ListNode result = new ListNode(0);
		ListNode tail = result;
		
		while(ptr1 != null && ptr2 != null) {
			if(ptr1.data <= ptr2.data) {
				tail.next = ptr1;
				ptr1 = ptr1.next;
			}else {
				tail.next = ptr2;
				ptr2 = ptr2.next;
			}
			tail = tail.next;
		}
		
		if(ptr1 == null) {
			tail.next = ptr2;
		}
		if(ptr2 == null) {
			tail.next = ptr1;
		}
		
		return result.next;
	}

	public ListNode addSumList(ListNode head1,ListNode head2) {
		if(head2 == null && head1 == null) {
			return null;
		}
		else if (head2 == null) {
			return head1;
		}else if (head1 == null) {
			return head2;
		}
		
		ListNode ptr1 = head1;
		ListNode ptr2 = head2;
		ListNode result = new ListNode(0);
		ListNode tail = result;
		int sum =  0;
		int carry = 0;
		
		while(ptr1 != null || ptr2 != null) {
			int a = ptr1 != null ? ptr1.data : 0;
			int b = ptr2 != null ? ptr2.data : 0;
			sum = a + b + carry;
			tail.next = new ListNode((sum % 10));
			carry = sum/10;
			if(ptr1 != null) {
				ptr1 = ptr1.next;
			}
			if(ptr2 != null) {
				ptr2 = ptr2.next;
			}
			
			tail = tail.next;
		}
		
		if(carry > 0) {
			tail.next = new ListNode(carry);
		}

		return result.next;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(1);
		ListNode secondNode = new ListNode(1);
		ListNode thirdNode = new ListNode(1);
		ListNode fourthNode = new ListNode(2);
		
		// connecting the nodes
		sll.head.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		
		sll.display();
		System.out.println("Length is - " + sll.length());
		sll.insertFirst(1);
		sll.display();
		sll.insertLast(3);
		sll.display();
		sll.insertAt(4,7);
		sll.display();
		sll.deleteFirst();
		System.out.println("Deleted node is : " +  sll.deleteLast().data);
		//sll.deleteAt(3);
		sll.display();
		System.out.println("find: " + (sll.find(843)  ? "Found": "Not Found"));
		//sll.reverseList(sll.head);
		System.out.println("Middle node is : " +sll.getMiddleNode().data);
		System.out.println("Nth node from the end is : " +sll.getNodeFromEnd(1).data);
		sll.removeDuplicate();
		sll.insertInSortedList(2);
		sll.deleteAt(2);
		sll.display();
		sll.createLoopInLL();
		System.out.println("Contains loop : " +sll.containsLoop());
		System.out.println("Starting node in the loop : " +sll.startNodeInLoop().data);
		System.out.println("Contains loop : " +sll.containsLoop());
		
		//sll.head = sll.mergeSortList(sll.createLinkedList(5), sll.createLinkedList(5));
		//sll.display(sll.head);	
		
		sll.head = sll.addSumList(sll.createLinkedList(3), sll.createLinkedList(5));
		sll.display(sll.head);
	
	}


}
