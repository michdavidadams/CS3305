package assignmentthree;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.64.2

import java.util.ArrayList;

public class MyStackMichaelAdams<E> {
    // Current size of stack
    int size;
    // Maximum size of stack
    int MAX_SIZE;
    // Data array
    ArrayList<E> S;
    // Index of top
    E top;

    MyStackMichaelAdams() {
        size = 0;
        MAX_SIZE = 0;
        top = null;
        S = new ArrayList<>();
    }

    // Returns true if stack is empty
    public boolean isEmpty() {
        if (S.isEmpty()) {
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
        return S.get(0);
    }

    // Returns and removes top element in stack
    public E pop() {
        if (!isEmpty()) {
            top = S.get(size - 1);
            S.remove(size - 1);
            size--;
        }
        return S.get(size - 1);
    }

    // Adds new element to top of stack
    public E push(E element) throws RuntimeException {
        if (size >= MAX_SIZE) {
            throw new RuntimeException("Max size reached.");
        }
        top = element;
        S.add(element);
        size++;
        return element;
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
