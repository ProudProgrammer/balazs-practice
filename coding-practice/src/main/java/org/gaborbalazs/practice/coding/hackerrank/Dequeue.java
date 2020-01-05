package org.gaborbalazs.practice.coding.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dequeue {

	public static void main(String[] args) throws FileNotFoundException {
		long counter = System.currentTimeMillis();
		Scanner in = new Scanner(
				new File("C:\\Balazs\\MyRepos\\balazs-practice\\src\\main\\java\\hu\\gaborbalazs\\test\\input.txt"));
		Deque<Integer> deque = new ArrayDeque<>();
		Map<Integer, Integer> uniqNumberCounter = new HashMap<>();
		int n = in.nextInt();
		int m = in.nextInt();
		long maxNum = 0;
		int next = 0;
		int last = 0;
		for (int i = 0; i < n; i++) {
			next = in.nextInt();
			deque.addLast(next);
			if (uniqNumberCounter.containsKey(next)) {
				uniqNumberCounter.put(next, uniqNumberCounter.get(next) + 1);
			} else {
				uniqNumberCounter.put(next, 1);
			}
			if (i >= m) {
				last = deque.removeFirst();
				if (uniqNumberCounter.get(last) == 1) {
					uniqNumberCounter.remove(last);
				} else {
					uniqNumberCounter.put(last, uniqNumberCounter.get(last) - 1);
				}
			}
			if (uniqNumberCounter.size() > maxNum) {
				maxNum = uniqNumberCounter.size();
			}
		}
		System.out.println(maxNum);
		System.out.println(System.currentTimeMillis() - counter);
		in.close();
	}
}
