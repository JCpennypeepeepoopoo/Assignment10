package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap<T> implements PriorityQueue<T>{
    private T[] binaryHeap;
    private int count;
    private Comparator<? super T> cmp;

    public BinaryMaxHeap() {
        binaryHeap = (T[]) new Object[10];
        cmp = null;
    }

    public BinaryMaxHeap(Comparator<? super T> cmp) {
        binaryHeap = (T[]) new Object[10];
        this.cmp = cmp;
    }

    public BinaryMaxHeap(List<? extends T> list) {
    }

    public BinaryMaxHeap(List<? extends T> list, Comparator<? super T> cmp) {
    }
    @Override
    public void add(T item) {

    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size() == 0)
            throw new NoSuchElementException();
        return binaryHeap[1];
    }

    @Override
    public T extractMax() throws NoSuchElementException {
        return null;
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

    @Override
    public Object[] toArray() {
        Object[] result = new Object[count];
        for (int i = 1; i < count + 1; i++)
            result[i - 1] = binaryHeap[i];

        return result;
    }
}
