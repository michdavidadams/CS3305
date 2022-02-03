package assignmenttwo;

public class MyLinkedListMichaelAdams <T> {
	Node head;
	Node tail;
	int size;

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
	
	MyLinkedListMichaelAdams(){
		head = null;
		tail = null;
		size = 0;
	}
	public T getFirst() throws RuntimeException{
		if (head == null) {
			throw new RuntimeException("Head is null");
		} else {
			return head.data;
		}
	}
	public T getLast() throws RuntimeException{
		if (tail == null) {
			throw new RuntimeException("Tail is null");
		} else {
			return tail.data;
		}
	}
	public void addLast(T newElement){
		Node newNode = new Node(newElement);
		newNode.link = tail;
		tail = newNode;
		if(size==0) {
			tail = newNode;
		}
		size++;
	}
	public void removeLast(){
		// Case 1: if the list is empty --> throw any Exception with a mess
		if (tail == null) {
			try {
				throw new Exception("List is empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Case 2: if you have only one element
		} else if (tail == head) {
			tail = null;
			size --;
			// Case 3: in general case
		} else {
			tail = tail.link;
			size--;
		}
	}
	
	public int indexOf(T targetElement){
		// search the targetElement in the list, return the index of given targetElement if it exists.
		// if the list doesn't have targetElement, return -1
		// Caution: index starts with 0  (the first element's index is 0)
		// Caution: to return index, you must check the index of node while you searching
		// Write code here
	}
	public Iterator iterator(){
		return new Iterator();
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
	
}
