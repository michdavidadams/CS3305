package assignmentthree;
// Class:			Data Structures W01

// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.63.2

public class MyStackMichaelAdams<E> {
    // Current size of stack
    int size;
    // Maximum size of stack
    int MAX_SIZE;
    // Data array
    E[] S;
    // Index of top
    int top;

    MyStackMichaelAdams() {
        size = 0;
        MAX_SIZE = 0;
        S={0};
        top = 0;
    }

    // Returns true if stack is empty
    public boolean isEmpty() {
        if (size == 0) {
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
        if (size != 0) {
            return S[top];
        }
        return null;
    }

    // Returns and removes top element in stack
    public E pop() {
        if (!isEmpty()) {
            top = top - 1;
            size--;
        }
        return S[top];
    }

    // Adds new element to top of stack
    public E push(E element) {
        if (size <= MAX_SIZE) {
            top = top + 1;
            S[top] = element;
            size++;
        }
        return null;
    }

    // Returns string containing all elements in stack
    public String toString() {
        if (!isEmpty()) {
            String stringStack = "";
            for (E i : S) {
                stringStack += i + " ";
            }
            return stringStack;
        }
        return null;
    }
}
