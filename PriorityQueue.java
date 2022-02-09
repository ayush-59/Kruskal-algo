package Kruskal;
import java.util.Comparator;
import java.util.ArrayList;

class PriorityQueue<E extends Comparable<E>> {
	ArrayList<E> heap;
	int size;
	Comparator<E> comparator;
	
	public PriorityQueue() {
		heap = new ArrayList<>();
		size = 0;
		this.comparator = null;
	}
	public PriorityQueue(int initialSize) {
		heap = new ArrayList<>(initialSize);
		size = 0;
		this.comparator = null;
	}
	public PriorityQueue(int initialSize, Comparator<E> comparator) {
		heap = new ArrayList<>(initialSize);
		size = 0;
		this.comparator = comparator;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public void add(E val) {
		heap.add(val);
		swim(size);
		size++;
	}
	public E get() {
		if(isEmpty())
			return null;
		E obj = heap.get(0);
		
		heap.set(0, heap.get(--size));
		sink(0);
		return obj;
	}
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.print(heap.get(i) + " ");
		}
	}

	private void swap(int x, int y) {
		E temp = heap.get(x);
		heap.set(x, heap.get(y));
		heap.set(y, temp);
	}
	
	private void swim(int k) {
		if(k==0)
			return;
		if(cmp(heap.get((k-1)/2), heap.get(k)) > 0){
			swap((k-1)/2,k);
			swim((k-1)/2);
		}
	}
	private int cmp(E a, E b) {
		if(comparator == null)
			return a.compareTo(b);
		
		return comparator.compare(a, b);
	}
	private void sink(int k) {
		int minChild;
		while(2*k + 2 < size) {
			if(cmp(heap.get(2*k+1), heap.get(2*k+2)) < 0 )
				minChild = 2*k+1;
			else
				minChild = 2*k+2;
			
			if(cmp(heap.get(minChild), heap.get(k)) < 0) {
				swap(minChild, k);
				k = minChild;
			}else {
				break;
			}
		}
	}
	
}

