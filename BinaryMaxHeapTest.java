package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryMaxHeapTest {
	int[] expectedMax = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
	int[] expectedMin = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testExtractMax() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(1);
		heap.add(2);
		assertEquals(heap.extractMax(), 2);
	}
	
	@Test
	void testAdd() {
//		Makes sure there are no errors.
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(100);
		heap.add(100);
		heap.add(60);
		heap.add(100);
		heap.add(-34);
		heap.add(99);
	}
	
	@Test
	void testSizeAndClear() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		assertEquals(heap.size(), 0);
		heap.add(10);
		heap.add(9);
		heap.add(10);
		assertEquals(heap.size(), 3);
		heap.clear();
		assertEquals(heap.size(), 0);
	}
	
	@Test
	void testIsEmpty() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		assertTrue(heap.isEmpty());
		heap.add(1);
		assertFalse(heap.isEmpty());
		heap.extractMax();
		assertTrue(heap.isEmpty());
	}
	
	@Test
	void testToArray() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		int[] expected = {100,99,99,1,2};
		heap.add(1);
		heap.add(100);
		heap.add(99);
		heap.add(99);
		heap.add(2);
		Object[] arr = heap.toArray();
		for(int i = 0; i < 5; i++) {
			assertEquals((int)arr[i], expected[i]);
			
		}
		
	}
	
//	Tests for the four constructors.
	@Test
	void testDefaultConstructor() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.add(30);
		heap.add(40);
		heap.add(10);
		heap.add(90);
		heap.add(80);
		heap.add(60);
		heap.add(20);
		heap.add(100);
		heap.add(50);
		heap.add(70);
		for(int i = 0; i < 9; i++) {
			assertEquals(expectedMax[i], heap.extractMax());
		}
	}
	
	@Test
	void testComparatorConstructor() {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>((o1, o2) -> o2.compareTo(o1));
		heap.add(20);
		heap.add(10);
		heap.add(60);
		heap.add(90);
		heap.add(70);
		heap.add(40);
		heap.add(30);
		heap.add(100);
		heap.add(80);
		heap.add(50);
		for(int i = 0; i < 9; i++) {
			assertEquals(expectedMin[i], heap.extractMax());
		}
	}
		
		@Test
		void testListConstructor() {	
		List<Integer> list = new ArrayList<>();
		for(int i = 10; i < 101; i += 10) {
			list.add(i);
		}
		Collections.shuffle(list);
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>(list);
		for(int i = 0; i < 9; i++) {
			assertEquals(expectedMax[i], heap.extractMax());
		}
	}
		
		@Test
		void testListComparatorConstructor() {	
		List<Integer> list = new ArrayList<>();
		for(int i = 10; i < 101; i += 10) {
			list.add(i);
		}
		Collections.shuffle(list);
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>(list, (o1, o2) -> o2.compareTo(o1));
		for(int i = 0; i < 9; i++) {
			assertEquals(expectedMin[i], heap.extractMax());
		}
	}
}
