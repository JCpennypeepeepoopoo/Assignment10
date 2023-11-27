package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class contains generic method for BinaryMaxHeap
 *
 * @author John Chen and Jacob Fowles
 * @version November 27, 2023
 */
public class BinaryMaxHeap<T> implements PriorityQueue<T>{
    private T[] binaryHeap;
    private int count;
    private Comparator<? super T> cmp;

    /**
     * This constructor sets the comparator to null and starting binary heap size 10
     */
    public BinaryMaxHeap() {
        binaryHeap = (T[]) new Object[10];
        cmp = null;
    }

    /**
     * This constructor sets the comparator to the comparator from the parameter
     * @param cmp - comparator
     */
    public BinaryMaxHeap(Comparator<? super T> cmp) {
        binaryHeap = (T[]) new Object[10];
        this.cmp = cmp;
    }

    /**
     * This constructor sets the BMH from the list in the parameter
     * @param list - List of items
     */
    public BinaryMaxHeap(List<? extends T> list) {
    }


    /**
     *
     * @param list
     * @param cmp
     */
    public BinaryMaxHeap(List<? extends T> list, Comparator<? super T> cmp) {
    }


    @Override
    public void add(T item) {
        if (binaryHeap.length == count)
            doubleHeapSize();
        if (count == 0)
            binaryHeap[1] = item;
        else {
            binaryHeap[count + 1] = item;
            percolateUp(count + 1);
        }
        count++;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size() == 0)
            throw new NoSuchElementException();
        return binaryHeap[1];
    }

    @Override
    public T extractMax() throws NoSuchElementException {
        if (count == 0)
            throw new NoSuchElementException();

        T temp = binaryHeap[1];
        binaryHeap[1] = binaryHeap[count + 1];
        binaryHeap[count + 1] = null;
        percolateDown(1);
        count--;
        return temp;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        binaryHeap = (T[]) new Object[10];
        count = 0;
    }

    /**
     * This method returns the BinaryMaxHeap in an array form
     * @return -
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[count];
        for (int i = 1; i < count + 1; i++)
            result[i - 1] = binaryHeap[i];
        return result;
    }

    /**
     * This method compares the 2 elements.
     * @param element1 - Element 1
     * @param element2 - Element 2
     * @return - An int to decide which element is larger
     */
    private int comparable(T element1, T element2) {
        if (cmp == null)
            return ((Comparable<? super T>) element1).compareTo(element2);
        return cmp.compare(element1, element2);
    }

    private void percolateUp(int index) {
        while (index != 1 && comparable(binaryHeap[index], binaryHeap[index / 2]) > 0) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void percolateDown(int index) {
        while (true) {
            // If the right kids exist, and it is greater than the parents
            if (2 * index + 1 <= count && comparable(binaryHeap[index], getRightKids(index)) < 0) {
                if (comparable(getLeftKids(index), getRightKids(index)) > 0) {
                    swap(index, 2 * index);
                    index = 2 * index;
                } else {
                    swap(index, 2 * index + 1);
                    index = 2 * index + 1;
                }
            }
            // If the left child exist and there is no right child
            else if (2 * index <= count && comparable(binaryHeap[index], getLeftKids(index)) < 0) {
                swap(index, 2 * index);
                index = 2 * index;
            } else
                break;
        }
    }

    private T getRightKids(int index) {
        if (binaryHeap[2 * index + 1] == null)
            return null;
        return binaryHeap[2 * index + 1];
    }

    private T getLeftKids(int index) {
        if (binaryHeap[2 * index] == null)
            return null;
        return binaryHeap[2 * index];
    }

    /**
     * This private method double the size of the BinaryMaxHeap size.
     */
    private void doubleHeapSize() {
        T[] doubleSize = (T[]) new Object[binaryHeap.length * 2];
        if (count + 1 - 1 >= 0) System.arraycopy(binaryHeap, 1, doubleSize, 1, count + 1 - 1);
        binaryHeap = doubleSize;
    }

    /**
     * This method swaps the
     * @param index1 - Location of the first index
     * @param index2 - Location of the second index
     */
    private void swap(int index1, int index2) {
        T temp1 = binaryHeap[index1];
        T temp2 = binaryHeap[index2];
        binaryHeap[index2] = temp1;
        binaryHeap[index1] = temp2;
    }

    private void buildHeap() {
        for (int i = count / 2; i > 0; i--)
            percolateDown(i);
    }
}
