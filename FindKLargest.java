package assign10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindKLargest {
	
	/**
	 * Determines the k largest items in the given list, using a binary max heap and the 
	 * natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestHeap(List<E> items, int k) throws IllegalArgumentException {
		if(k <= 0 || k > items.size()) {
			throw new IllegalArgumentException("Invalid value for K");
		}
		BinaryMaxHeap<E> heap = new BinaryMaxHeap<>(items);
		ArrayList<E> returnList = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			returnList.add(heap.extractMax());
		}
//		System.out.println(returnList);
		return returnList;
	}

	/**
	 * Determines the k largest items in the given list, using a binary max heap.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @param cmp - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E> List<E> findKLargestHeap(List<E> items, int k, Comparator<? super E> cmp) throws IllegalArgumentException {
		if(k <= 0 || k > items.size()) {
			throw new IllegalArgumentException("Invalid value for K");
		}
		BinaryMaxHeap<E> heap = new BinaryMaxHeap<>(items, cmp);
		ArrayList<E> returnList = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			returnList.add(heap.extractMax());
		}
//		System.out.println(returnList);
		return returnList;
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine and the 
	 * natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestSort(List<E> items, int k) throws IllegalArgumentException {
		if(k <= 0 || k > items.size()) {
			throw new IllegalArgumentException("Invalid value for K");
		}
		List<E> returnList = new ArrayList<E>();
		Collections.sort(items);
		for(int i = items.size()-1; i >= k-1; i--) {
			returnList.add(items.get(i));
		}
//		System.out.println(returnList);
		return returnList;
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine.
	 * 
	 * @param items - the given list
	 * @param k - the number of largest items
	 * @param cmp - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of the given list
	 */
	public static <E> List<E> findKLargestSort(List<E> items, int k, Comparator<? super E> cmp) throws IllegalArgumentException {
		if(k <= 0 || k > items.size()) {
			throw new IllegalArgumentException("Invalid value for K");
		}
		List<E> returnList = new ArrayList<E>();
		items.sort(cmp);
		for(int i = items.size()-1; i >= k-1; i--) {
			returnList.add(items.get(i));
		}
//		System.out.println(returnList);
		return returnList;
		
	}
}