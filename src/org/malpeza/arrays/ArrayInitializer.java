package org.malpeza.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayInitializer {
	private List<Long> durations = new ArrayList<>();

	public void initMethodA(final int size) {
		final int[][] arr = new int[size][size];
		final int val = 2;

		final long start = System.nanoTime();
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] = val;
			}
		}

		final long end = System.nanoTime();
		durations.add(end - start);
	}

	public void initMethodB(final int size) {
		final int[][] arr = new int[size][size];
		final int val = 2;

		final long start = System.nanoTime();
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				arr[col][row] = val;
			}
		}
		final long end = System.nanoTime();

		durations.add(end - start);
	}

	public void initMethodC(final int size, final List<AccessPair> pairs) {
		final int[][] arr = new int[size][size];
		final int val = 2;

		final long start = System.nanoTime();
		for (AccessPair pair : pairs) {
			arr[pair.row][pair.col] = val;
		}
		final long end = System.nanoTime();

		durations.add(end - start);
	}

	public long getLastDuration() {
		return durations.isEmpty() ? 0 : durations.get(durations.size() - 1);
	}

	public double getAverageDuration() {
		if (durations.isEmpty()) {
			return 0;
		}

		double sum = 0;
		for (Long duration : durations) {
			sum += duration;
		}

		return sum / durations.size();
	}

	public List<AccessPair> buildPairs(final int rndCells, final int size) {
		System.out.println("Building " + rndCells + " pairs...");
		final List<AccessPair> pairs = new ArrayList<>(rndCells);
		final Random rnd = new Random();

		for (int i = 0; i < rndCells; i++) {
			pairs.add(new AccessPair(rnd.nextInt(size), rnd.nextInt(size)));
		}

		System.out.println("End building pairs.");
		return pairs;
	}

}
