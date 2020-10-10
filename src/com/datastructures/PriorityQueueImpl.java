package com.datastructures;
/*
 Priority Queue introduction and Java implementation

A priority queue is an abstract data type, it is like a regular queue or stack data structure, but where additionally each element has a priority associated with it. In a priority queue, an element with high priority is served before an element with low priority. If two elements have the same priority, they are served according to their order in the queue.

There are a variety of simple ways to implement a priority queue. For instance, one can keep all the elements in an unsorted list. Whenever the highest-priority element is requested, search through all elements for the one with the highest priority. In big O notation: O(1) insertion time, O(n) pull time due to search.

Below example shows basic implementation of priority queue. The condition here is, the element to be inserted should implement Comparable interface, we have taken Integer object, which is already implementing this interface.

- See more at: http://java2novice.com/data-structures-in-java/queue/priority-queue/#sthash.PInm9DEZ.dpuf 
 */

public class PriorityQueueImpl {
	 
    
    private Comparable[] pQueue;
    private int index;
     
    public PriorityQueueImpl(int capacity){
        pQueue = new Comparable[capacity];
    }
     
    public void insert(Comparable item ){
        if(index == pQueue.length){
            System.out.println("The priority queue is full!! can not insert.");
            return;
        }
        pQueue[index] = item;
        index++;
        System.out.println("Adding element: "+item);
    }
     
    
    public Comparable remove(){
        if(index == 0){
            System.out.println("The priority queue is empty!! can not remove.");
            return null;
        }
        int maxIndex = 0;
        // find the index of the item with the highest priority
        for (int i=1; i<index; i++) {
            if (pQueue[i].compareTo (pQueue[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        Comparable result = pQueue[maxIndex];
        System.out.println("removing: "+result);
        // move the last item into the empty slot
        index--;
        pQueue[maxIndex] = pQueue[index];
        return result;
    }
     
    public static void main(String a[]){
        PriorityQueueImpl pqi = new PriorityQueueImpl(5);
        pqi.insert(34);
        pqi.insert(23);
        pqi.insert(5);
        pqi.insert(87);
        pqi.insert(32);
        pqi.remove();
        pqi.remove();
        pqi.remove();
        pqi.remove();
        pqi.remove();
    }
}
