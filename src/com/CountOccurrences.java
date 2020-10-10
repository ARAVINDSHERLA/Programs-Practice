package com;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CountOccurrences extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;
 
    private static final int SEQUENTIAL_THRESHOLD = 5;
 
    private final int[] data;
    private final int start;
    private final int end;
    private final int value;
   
    public CountOccurrences(int[] data, int start, int end, int value) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.value = value;
       }
 
    public CountOccurrences(int[] data, int value) {
        this(data, 0, data.length, value);
        }
 
    @Override
    protected Integer compute() {
        final int length = end - start;
        if (length < SEQUENTIAL_THRESHOLD) {
            return computeDirectly();
        }
        final int split = length / 2;
        final CountOccurrences left = new CountOccurrences(data, start, start
                + split, value);
        left.fork();
        final CountOccurrences right = new CountOccurrences(data,
                start + split, end, value);
        right.fork();
        return left.join()+right.join();
    }
 
    private Integer computeDirectly() {
        System.out.println(Thread.currentThread() + "calculating: " + start
                + " to " + end);
        int count = 0;
        for (int i = start; i < end; i++) {
            if (data[i] == value) {
                count++;
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
        final int[] data = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            data[i] = random.nextInt(10);
            System.out.print(data[i] + ", ");
        }
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("value-->"+numberOfProcessors);
        // submit the task to the pool
        final ForkJoinPool pool = new ForkJoinPool(7);
        int value = 5;
        final CountOccurrences finder = new CountOccurrences(data, value);
        System.out.println("Number of occurrences of value " + value + " is: "
                + pool.invoke(finder));
    }
}