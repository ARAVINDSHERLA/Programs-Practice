package com.datastructures;


/*Linked List Data Structure

A linked list is a data structure consisting of a group of nodes which together represent a sequence. Each node is composed of a data and a link or reference to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the sequence.The last node is linked to a terminator used to signify the end of the list.

Linked List Data Structure - Java2Novice

Linked lists are the simplest and most common data structures. They can be used to implement several other abstract data types, including lists, stacks, queues, associative arrays, and S-expressions, etc.

The benefits of a linked list over a conventional array is that the linked list elements can easily be inserted or removed without reallocation or reorganization of the entire structure because the data items need not be stored contiguously in memory or on disk. Linked lists allow insertion and removal of nodes at any point in the list.

On the other hand, simple linked lists do not allow random access to the data, or by using indexing. Thus, many basic operations like obtaining the last node of the list, or finding a node with required data, or locating the place where a new node should be inserted, may require scanning most of the list elements.

List of Linked List Data Structure Examples
Singly linked list implementation in java
Doubly linked list in Java
*/
/*
Singly linked list implementation

Singly Linked Lists are a type of data structure. It is a type of list. In a singly linked list each node in the list stores the contents of the node and a pointer or reference to the next node in the list. It does not store any pointer or reference to the previous node. It is called a singly linked list because each node only has a single link to another node. To store a single linked list, you only need to store a reference or pointer to the first node in that list. The last node has a pointer to nothingness to indicate that it is the last node.

Here is the pictorial view of singly linked list:

- See more at: http://java2novice.com/data-structures-in-java/linked-list/singly-linked-list/#sthash.5pjRPofK.dpuf


*/
public class SingleLinkedListImpl<T> {
	 
    private Node1<T> head;
    private Node1<T> tail;
     
    public void add(T element){
         
        Node1<T> nd = new Node1<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNextRef(nd);
            //set tail as newly created node
            tail = nd;
        }
    }
     
    public void addAfter(T element, T after){
         
        Node1<T> tmp = head;
        Node1<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            //add element after the target node
            Node1<T> nd = new Node1<T>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
             
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        Node1<T> tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }
     
    public void deleteAfter(T after){
         
        Node1<T> tmp = head;
        Node1<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void traverse(){
         
        Node1<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }
     
    public static void main(String a[]){
        SingleLinkedListImpl<Integer> sl = new SingleLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.addAfter(76, 54);
        sl.deleteFront();
        sl.deleteAfter(76);
        sl.traverse();
         
    }
}
 
class Node1<T> implements Comparable<T> {
     
    private T value;
    private Node1<T> nextRef;
     
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Node1<T> getNextRef() {
        return nextRef;
    }
    public void setNextRef(Node1<T> ref) {
        this.nextRef = ref;
    }
    @Override
    public int compareTo(T arg) {
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }
}
