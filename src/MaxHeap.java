import java.util.*;


public class MaxHeap<K, V> {

List<HeapEntry<K,V>> entries; //USE
int capacity;
int heapSize = 0;
Comparator comparator;
HeapEntry<K, V>[] items; //TODO

    public MaxHeap(int capacity, Comparator comparator){
        // Constructor for the max heap
		this.capacity = capacity;
		this.comparator = comparator;
		this.items = new HeapEntry[capacity]; // TODO
		this.entries = new ArrayList<HeapEntry<K,V>>();
		
    }

	public void add(K key, V value){
	    // Method to add the key value pair in the heap, remember to satisfy max heap Property
		ensureCapacity(); 
		items[heapSize] =  new HeapEntry(key, value);
		//System.out.println("hi Ive been here!: " + ((Student)items[heapSize].value).name);
		bubbleUp();
		heapSize ++;
	}

	public HeapEntry<K,V> peek() {
		// Method to return the max element in the heap
		if (heapSize == 0) {return null; }

		return items[0];
	}
	
	public HeapEntry<K,V> remove() {
		//Method to remove the max element in the heap, remember to satisfy max heap Property
		if (heapSize == 0) {return null; }

		HeapEntry<K,V> maxItem = items[0];
		items[0] = items[heapSize - 1];

		bubbleDown();
		System.out.println("Am I here?");
		heapSize --;
		return maxItem;
	}	

	public void ensureCapacity() { // 2n
		if (heapSize == capacity) { // No extra room at tail
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	public void bubbleUp(){ //
	// take the leaf item up
		int currIdx = heapSize;
		while (hasParent(currIdx) ) {
			int parentIdx = getParentIdx(currIdx);
			//if value of curr > value of parent
			if (comparator.compare((items[currIdx].value), (items[parentIdx].value)) > 0) {

				swap(parentIdx, currIdx);
				currIdx = parentIdx;
			}else {
				break;
			}
		}
	} 
	public void bubbleDown(){
	// take the root item down	
		int currIdx = 0;
		while (hasLeftChild(currIdx)) {
			int leftIdx = getLeftChildIdx(currIdx);
			int maxChildIdx = getLeftChildIdx(currIdx);

			if (hasRightChild(currIdx)) {
				int rightIdx = getRightChildIdx(currIdx);
				// if rightChild > leftChild, maxChild = rightChild
				if (comparator.compare(items[leftIdx].value, items[rightIdx].value) < 0 ) {
					maxChildIdx = rightIdx;
				}
			}
			//if curr < maxChild, swap
			if (comparator.compare(items[currIdx].value, items[maxChildIdx].value) < 0 ) {
				swap(currIdx, maxChildIdx);
				currIdx = maxChildIdx;
			}else{ break; } 
		}
	}

	public void swap(int index1, int index2){
		HeapEntry temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	public int getParentIdx(int childIdx) { return (childIdx - 1) / 2; }
	public int getLeftChildIdx(int parentIdx) { return 2 * parentIdx + 1; }
	public int getRightChildIdx(int parentIdx) { return 2 * parentIdx + 2; }

	public boolean hasParent(int i) {return getParentIdx(i) >= 0; }
	public boolean hasLeftChild(int i) { return getLeftChildIdx(i) < heapSize; }
	public boolean hasRightChild(int i) { return getRightChildIdx(i) < heapSize; }

}

class HeapEntry<K, V> implements DefaultMap.Entry<K,V>{
	K key;
	V value;

	HeapEntry(K key, V value){
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value){
		this.value = value;
	}
}