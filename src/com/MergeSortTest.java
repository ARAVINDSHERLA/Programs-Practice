package com;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

 class MergeSort extends RecursiveAction {
	private static final int SEQUENTIAL_THRESHOLD = 50;
	final int[] numbers;
	final int startPos, endPos;
	final int[] result;

	public MergeSort(int[] numbers, int startPos, int endPos) {
		super();
		this.numbers = numbers;
		this.startPos = startPos;
		this.endPos = endPos;
		result = new int[endPos - startPos];
	}

	private void merge(MergeSort left, MergeSort right) {
		int i = 0, leftPos = 0, rightPos = 0, leftSize = left.size(), rightSize = right.size();
		while (leftPos < leftSize && rightPos < rightSize)
			result[i++] = (left.result[leftPos] <= right.result[rightPos]) ? left.result[leftPos++]
					: right.result[rightPos++];
		while (leftPos < leftSize)
			result[i++] = left.result[leftPos++];
		while (rightPos < rightSize)
			result[i++] = right.result[rightPos++];
	}

	public int size() {
		return endPos - startPos;
	}

	@Override
	 protected void compute() {
		if (size() < SEQUENTIAL_THRESHOLD) {// Sequential implementation
			System.arraycopy(numbers, startPos, result, 0, size());
			Arrays.sort(result, 0, size());
			
		} else {
			int midpoint = size() / 2;
			MergeSort left = new MergeSort(numbers, startPos, startPos + midpoint);
			MergeSort right = new MergeSort(numbers, startPos + midpoint, endPos);
			ForkJoinTask.invokeAll(left, right);
			merge(left, right);
			for(int i=0; i<result.length;i++){
               System.out.println(result[i]);
         }
			
		}
	}
	/*
	protected void compute() {
  if (low < high) {
    if (high - low <= MAX) { // Sequential implementation
      mergesort(array, helper, low, high);
    } else { // Parallel implementation
      final int middle = (low + high) / 2;
      final ParallelSmartMergeSort left = 
        new ParallelSmartMergeSort(array, low, middle);
      final ParallelSmartMergeSort right = 
        new ParallelSmartMergeSort(array, middle + 1, high);
      invokeAll(left, right);
      merge(array, helper, low, middle, high);
    }
  }
}
	 */
}

public class MergeSortTest {
	public static void main(String[] args) {
		int n = 1000;
		Random random = ThreadLocalRandom.current();
		int[] array = new int[n];
		for (int i = 0; i < n; ++i) {
			array[i] = random.nextInt(100);
			 System.out.print(array[i] + ", ");
		}
		final ForkJoinPool pool = new ForkJoinPool(7);
		long start = System.currentTimeMillis();
		ForkJoinTask task=new MergeSort(array, 0, array.length);
		System.out.println(pool.invoke(task));
		
		long end = System.currentTimeMillis();
		System.out.println(String.format("%d [msec]", (end-start)));
	}
}