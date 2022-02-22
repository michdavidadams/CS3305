package assignmentthree;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.64.2

public class MyStackMichaelAdams<E> {
    // Current size of stack
    int size;
    // Maximum size of stack
    int MAX_SIZE;
    // Data array
    E[] S;
    // Index of top
    E top;

    MyStackMichaelAdams() {
    }

    // Returns true if stack is empty
    public boolean isEmpty() {
        if (S.length <= 0) {
            return true;
        }
        return false;
    }

    // Returns number of elements in stack
    public int size() {
        return size;
    }

    // Returns top element in stack
    public E peek() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return S[0];
    }

    // Returns and removes top element in stack
    public E pop() {
        if (!isEmpty()) {
            top = S[size - 1];
            S[size - 1] = null;
            size--;
        }
        return S[size - 1];
    }

    // Adds new element to top of stack
    public E push(E element) {
        if (size > MAX_SIZE) {
            System.out.println("Max size reached.");
        } else {
        this.top = element;
        this.S[size] = element;
        this.size++;
        return element;
        }
        return null;
    }

    // Returns string containing all elements in stack
    public String toString() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        String stringStack = "";
        for (E i : S) {
            stringStack += i + " ";
        }
        return stringStack;
    }
}
