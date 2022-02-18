package assignmenttwo;

public class MyLinkedListTesterMichaelAdams {
	
	public static void printTestName(String str) {
		System.out.println();
		System.out.println("=================================");
		System.out.println("\t" + str);
		System.out.println("=================================");
	}

	public static void showExceptionMessage(String str) {
		System.out.println("#################################");
		System.out.println("Exception Occurs in Tester [" + "]");
		System.out.println("#################################");
		System.out.println();
	}
	public static void main(String[] args) {
		
		// Checking addFirst() correctly works
		try {
			linkedListTester1(); // add first must work because it is given by me.
		}catch(Exception e) {
			showExceptionMessage("1");
		}
		// Checking addLast() correctly works
		try {linkedListTester2();} catch(Exception e) {showExceptionMessage("2");}		
		// Checking add() correctly works
		try {linkedListTester3();} catch(Exception e) {showExceptionMessage("3");}		
		// Checking removeFirst() correctly works
		try {linkedListTester4();} catch(Exception e) {showExceptionMessage("4");}		
		// Checking removeLast() correctly works
		try {linkedListTester5();} catch(Exception e) {showExceptionMessage("5");}		
		// Checking remove() correctly works
		try {linkedListTester6();} catch(Exception e) {showExceptionMessage("6");}		
		// Checking getFirst() correctly works
		try {linkedListTester7();} catch(Exception e) {showExceptionMessage("7");}		
		// Checking getLast() correctly works
		try {linkedListTester8();} catch(Exception e) {showExceptionMessage("8");}		
		// Checking indexOf() correctly works
		try {linkedListTester9();} catch(Exception e) {showExceptionMessage("9");}		
		
		// Checking Iterator correctly works
		try {linkedListIteratorTest1();} catch(Exception e) {showExceptionMessage("Iterator");}
		
	}
	public static void linkedListTester1() {
		printTestName("[1] addFirst() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();

		myList.addFirst("CC");
		myList.addFirst("BB");
		myList.addFirst("AA");
	
		System.out.println(myList + "  <-- Your List");
		System.out.println("[AA, BB, CC]  <-- Correct List");
		
	}
	public static void linkedListTester2() {
		printTestName("[2] addLast() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();

		myList.addLast("CC");
		myList.addLast("BB");
		myList.addLast("AA");
	
		System.out.println(myList + "  <-- Your List");
		System.out.println("[CC, BB, AA]  <-- Correct List");
		
	}
	public static void linkedListTester3() {
		printTestName("[3] add() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();

		myList.add(0,"DD");
		myList.add(0,"CC");
		myList.add(0,"BB");
		myList.add(3,"EE");
		myList.add(0,"AA");
		System.out.println(myList + "  <-- Your List");
		System.out.println("[AA, BB, CC, DD, EE]  <-- Correct List");
		
	}
	public static void linkedListTester4() {
		printTestName("[4] removeFirst() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();
		
		myList.addFirst("CC");
		myList.addFirst("BB");
		myList.addFirst("AA");
		
		myList.removeFirst();
		myList.removeFirst();
		System.out.println(myList + "  <-- Your List");
		System.out.println("[CC]  <-- Correct List 1");
		
		myList.removeFirst();
		System.out.println(myList + "  <-- Your List");
		System.out.println("[]  <-- Correct List 1");
	}
	public static void linkedListTester5() {
		printTestName("[5] removeLast() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();
		
		myList.addFirst("CC");
		myList.addFirst("BB");
		myList.addFirst("AA");
		
		myList.removeLast();
		System.out.println(myList + "  <-- Your List");
		System.out.println("[AA, BB]  <-- Correct List");
		myList.removeLast();
		myList.removeLast();
		System.out.println(myList + "  <-- Your List");
		System.out.println("[]  <-- Correct List");
	}
	public static void linkedListTester6() {
		printTestName("[6] remove(index) Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();
		
		myList.addFirst("CC");
		myList.addFirst("BB");
		myList.addFirst("AA");
		
		myList.remove(0);
		System.out.println(myList + "  <-- Your List");
		System.out.println("[BB, CC]  <-- Correct List");
		myList.remove(1);
		System.out.println(myList + "  <-- Your List");
		System.out.println("[BB]  <-- Correct List");
	}
	public static void linkedListTester7() {
		printTestName("[7] getFirst() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();
		
		myList.addFirst("CC");
		myList.addFirst("BB");
		myList.addFirst("AA");
		
		System.out.println(myList.getFirst() + "  <-- Your element");
		System.out.println("AA  <-- Correct element");
	}
	public static void linkedListTester8() {
		printTestName("[8] getLast() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();
		
		myList.addFirst("CC");
		myList.addFirst("BB");
		myList.addFirst("AA");
		
		System.out.println(myList.getFirst() + "  <-- Your element");
		System.out.println("AA  <-- Correct element");
	}
	public static void linkedListTester9() {
		printTestName("[9] indexOf() Tester");
		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();
		
		myList.addFirst("DD");
		myList.addFirst("CC");
		myList.addFirst("BB");
		myList.addFirst("AA");
		
		System.out.println(myList.indexOf("CC") + "  <-- Your element");
		System.out.println("2  <-- Correct element");
	}
	public static void linkedListIteratorTest1() {
		printTestName("Iterator Tester");

		MyLinkedListMichaelAdams<String> myList = new MyLinkedListMichaelAdams<>();

		myList.addFirst("JKL");
		myList.addFirst("GHI");
		myList.addFirst("DEF");
		myList.addFirst("ABC");
		MyLinkedListMichaelAdams<String>.Iterator iter = myList.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println(" <-- Your List");
		System.out.println("ABC DEF GHI JKL  <-- Correct List");
	}

}
