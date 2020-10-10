package com.datastructures;

/*
Data Structures:
A data structure is a particular way of storing and organizing data in a computer so that it can be used 
efficiently. Data structures provide a means to manage large amounts of data efficiently. 
efficient data structures are a key to designing efficient algorithms. 
- See more at: http://java2novice.com/data-structures-in-java/#sthash.MBmlMThM.dpuf

1)stack
2)queue
3)LinkedList


 Stack introduction & implementation
Java Dynamic Stack Implementation
Stack implementation using generics bounded type.
Reverse a word or string using Stack data structure.
Write a program to find out delimiter matching using stack.
Convert a decimal into a binary number using stack.
Towers of Hanoi implementation using stack.
Evaluation of an infix expression that is fully parenthesized using stack in java.
- See more at: http://java2novice.com/data-structures-in-java/stacks/#sthash.v1HQQPNG.dpuf
 */





public class StackDemo {
	 
    private int stackSize;
    private int[] stackArr;
    private int top;
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public StackDemo(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top
     * of the stack
     * @param entry
     * @throws Exception
     */
    public void push(int entry) throws Exception {
        if(this.isStackFull()){
            throw new Exception("Stack is already full. Can not add element.");
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the
     * top of the stack.
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public int peek() {
        return stackArr[top];
    }
 
    /**
     * This method returns true if the stack is
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
 
    public static void main(String[] args) {
    	StackDemo stack = new StackDemo(5);
        try {
            stack.push(4);
            stack.push(8);
            stack.push(3);
            stack.push(89);
            stack.pop();
            stack.push(34);
            stack.push(45);
            stack.push(78);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
