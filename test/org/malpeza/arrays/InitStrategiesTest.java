package org.malpeza.arrays;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InitStrategiesTest {
	private ArrayInitializer arrayInitializer;
	private final int size = 8_000;
	private final int rndCells = 8_000 * 8_000;
	
	@Before
	public void setup(){
		arrayInitializer = new ArrayInitializer();
	}
	
	@After
	public void tearDown() {
		arrayInitializer = null;
	}
	
	@Test
	public void initialization_by_method_A() {
		System.out.println();
		for(int i = 0; i < 3; i++) {
			arrayInitializer.initMethodA(size);
			System.out.format("Init 'a' Time (nanos):\t %-20d %n", arrayInitializer.getLastDuration());
		}
		System.out.format("Init 'a' Avg (nanos):\t %-20.0f %n", arrayInitializer.getAverageDuration());
	}
	
	@Test
	public void initialization_by_method_B() {
		System.out.println();
		for(int i = 0; i < 3; i++) {
			arrayInitializer.initMethodB(size);
			System.out.format("Init 'b' Time (nanos):\t %-20d %n", arrayInitializer.getLastDuration());
		}
		System.out.format("Init 'b' Avg (nanos):\t %-20.0f %n", arrayInitializer.getAverageDuration());
	}

	@Test
	public void initialization_by_method_C() {
		System.out.println();
		
		List<AccessPair> pairs = arrayInitializer.buildPairs(rndCells, size);
		
		for(int i = 0; i < 3; i++) {
			arrayInitializer.initMethodC(size, pairs);
			System.out.format("Init 'c' Time (nanos):\t %-20d %n", arrayInitializer.getLastDuration());
		}
		System.out.format("Init 'c' Avg (nanos):\t\t %-20.0f %n", arrayInitializer.getAverageDuration());
	}
}
