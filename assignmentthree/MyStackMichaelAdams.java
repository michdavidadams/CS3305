package assignmentthree;
// Class:			Data Structures W01
// Term:			Spring 2022
// Name:			Michael Adams
// Program Number:	3
// IDE: 			Visual Studio Code 1.64.2

import java.util.ArrayList;
import java.util.List;

public class MyStackMichaelAdams<E> {
    public List<E> S = new ArrayList<>();

    // Returns true if stack is empty
    public boolean isEmpty() {
        return S.isEmpty();
    }

    // Returns number of elements in stack
    public int size() {
        return S.size();
    }

    // Returns top element in stack
    public E peek() {
        if (S.isEmpty()) {
            return null;
        }
        return S.get(S.size() - 1);
    }

    // Returns and removes top element in stack
    public E pop() {
		E character = S.get(S.size() - 1);
		S.remove(S.size() - 1);
		return character;
    }

    // Adds new element to top of stack
    public E push(E element) {
        S.add(element);
        return element;
    }

    // Returns string containing all elements in stack
    public String toString() {
        if (S.isEmpty()) {
            return "";
        }
        String stringStack = "";
        for (E i: S) {
            stringStack += i + "";
        }
        return stringStack;
    }

    public char getNext() {
		int index = 0;
		for(int y = 0; y < S.size(); y++) 
		{
			if(S.get(y) == null) {
				index = y-1;
				break;
			}
		}
		return (char) S.get(index);
	}

}
