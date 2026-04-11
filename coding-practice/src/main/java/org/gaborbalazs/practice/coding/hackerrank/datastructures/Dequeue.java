package org.gaborbalazs.practice.coding.hackerrank.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Dequeue {

	static void main(String[] args) throws FileNotFoundException {
		long counter = System.currentTimeMillis();
		Scanner in = new Scanner(new File("input.txt"));
		Deque<Integer> deque = new ArrayDeque<>();
		Map<Integer, Integer> uniqueNumberCounter = new HashMap<>();
		int n = in.nextInt();
		int m = in.nextInt();
		long maxNum = 0;
		int next = 0;
		int last = 0;
		for (int i = 0; i < n; i++) {
			next = in.nextInt();
			deque.addLast(next);
			if (uniqueNumberCounter.containsKey(next)) {
				uniqueNumberCounter.put(next, uniqueNumberCounter.get(next) + 1);
			} else {
				uniqueNumberCounter.put(next, 1);
			}
			if (i >= m) {
				last = deque.removeFirst();
				if (uniqueNumberCounter.get(last) == 1) {
					uniqueNumberCounter.remove(last);
				} else {
					uniqueNumberCounter.put(last, uniqueNumberCounter.get(last) - 1);
				}
			}
			if (uniqueNumberCounter.size() > maxNum) {
				maxNum = uniqueNumberCounter.size();
			}
		}
		System.out.println(maxNum);
		System.out.println(System.currentTimeMillis() - counter);
		in.close();
	}
}
