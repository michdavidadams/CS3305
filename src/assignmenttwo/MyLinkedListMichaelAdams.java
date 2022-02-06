package assignmenttwo;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	Assignment 2
// IDE: 			IntelliJ IDEA 2021.3.2

public class MyLinkedListMichaelAdams <T> {
	Node head;
	Node tail;
	int size;

	MyLinkedListMichaelAdams(){
		head = null;
		tail = null;
		size = 0;
	}

	// Gets the first element in the list
	public T getFirst() throws RuntimeException{
		// If head is empty, throw exception
		if (head == null) {
			throw new RuntimeException("Head is null");
			// Otherwise, returns first element in list
		} else {
			return head.data;
		}
	}

	// Get last element in list
	public T getLast() throws RuntimeException{
		// If tail is empty, throw exception
		if (tail == null) {
			throw new RuntimeException("Tail is null");
			// Otherwise, returns last element in list
		} else {
			return tail.data;
		}
	}

	// Add given element to end of list
	public void addLast(T newElement){
		// Create a new node to hold element
		Node newNode = new Node(newElement);
		// If list is empty, add node to beginning of list
		if(size==0) {
			addFirst(newElement);
			return;
		}
		tail.link = newNode;
		tail = newNode;
		size++;
	}

	// Removes last element in list
	public void removeLast(){
		// If list is empty, throw exception
		if(head == null) {
			throw new RuntimeException("in removeLast(): no elements in the list");
		}
		// If size of list is one, then remove the element
		else if(head == tail) {
			head = tail = null;
			size --;
		}
		// General case
		else {
			// Point the current node to beginning of list
			Node newNode = head;
			// While node isn't the tail, point node to next element
			while (newNode.link != tail) {
				newNode = newNode.link;
			}
			// Node is tail at this point, so null
			newNode.link = null;
			// Update tail to equal node
			tail = newNode;
		}
	}

	// Finds index of given targetElement in list and returns its index, if it exists.
	public int indexOf(T targetElement){
		int index = 0;
		// Points new node to head of list
		Node newNode = head;
		// While new node isn't empty
		while (newNode != null) {
			// If new node element equals given targetElement, return its index
			if (newNode.data.equals(targetElement)) {
				return index;
			}
			index++;
			// Update new node
			newNode = newNode.link;
		}

		// Return -1 by default
		return -1;
	}
	
	public Iterator iterator(){
		return new Iterator();
	}

	public void removeFirst() throws RuntimeException {
		if(head == null) {
			throw new RuntimeException("in removeFirst(): no elements in the list");
		}
		else if(head == tail) { // if(size==1)
			head = tail = null;
			size --;
		}
		else {
			head = head.link;
			size--;
		}

	}
	
	public void remove(int index) {
		if(index == 0) {
			removeFirst();
		}
		else if(head == tail) {
			head = tail = null;
			size--;
		}
		else {
			Node cur = head;
			while (--index > 0) {
				cur = cur.link;
			}
			Node targetNode = cur.link;
			cur.link = targetNode.link;
			size--;
			if(cur.link == null)
				tail = cur;
		}
	}
	
	public void addFirst(T newElement){
		Node newNode = new Node(newElement);
		newNode.link = head;
		head = newNode;
		if(size==0) {
			tail = newNode;
		}
		size++;
	}

	public void add(int index, T newElement) {
		if(index == 0)
			addFirst(newElement);
		else {
			Node temp1 = head;
			while (--index > 0) {
				temp1 = temp1.link;
			}
			Node newNode = new Node(newElement);
			newNode.link = temp1.link;
			temp1.link = newNode;

			if (newNode.link == null) {
				tail = newNode;
			}
			size++;
		}
	}
	
	public String toString() {
		String str = "[";
		Node temp = head;

		while(temp != null) {
			str = str + temp.data;
			if(temp != tail) {
				str = str + ", ";
			}
			temp = temp.link;
		}
		return str = str + "]";
	}
	
	public class Node{
		T data;
		Node link;
		Node(){
		}
		Node(T element){
			data = element;
			link = null;
		}
	}
	
	// Complete the Iterator class
	class Iterator {
		Node next; // to point [next node] object

		Iterator(){
			// next must be the first node of the list
                	next = head;
		}

		public T next(){
			 // return the data_field of [next node]
                	T data_field = next.data;
                	next = next.link;
                	return data_field;
		}
		public boolean hasNext(){
			// return true when the [next node] exists
                	// return false when we don't have the [next node]
                	if (next != null) {
                	    return true;
               	 	}
                	return false;
		}

	}
	
}
