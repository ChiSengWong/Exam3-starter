public class CircularArrayList<T> implements ArrayListADT<T>{
	
	int capacity;
	int size;
	int front;
	int rear;
	T[] arrayList;
	public static final int DEFAULT_INITIAL_CAPACITY = 100;

	
	public  CircularArrayList() {
		//Fill in the constructor for the circularArrayList
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public CircularArrayList(int initialCapacity) {
		//Fill in the constructor for the circularArrayList
		this.capacity = initialCapacity;
		this.size = 0;
		this.front = 0;
		this.rear = -1;
		this.arrayList = (T[]) new Object[capacity];
	}

	@Override
	public void addRear(T element) {
		//Method to add element at the rear of the arraylist

		ensureCapacity();
		int newRear = (rear + 1);
		arrayList[newRear] = element;
		rear = newRear;
		size ++;
		
	}

	@Override
	public void addFront(T element) {
		//Method to add element at the front of the arraylist i.e. towards start
		ensureCapacity();
		int newFront = (front - 1 + capacity) % capacity;
		arrayList[newFront] = element;
		front = newFront;
		size ++;

	}

	public T get(int index) throws Exception {
		//Method to get element at a given index of the circularArrayList
		T element = arrayList[(front + index) % capacity];
		if (element == null) {throw new Exception("Element doesn’t exist"); }
		return element;
	}
	
	@Override
	public T remove() {
		//Method to remove the element from the front
		T elementToRemove = arrayList[front];
		arrayList[front] = null; //TODO handle indexOutOfBound Exception
		front = (front + 1) % capacity;
		size --;
		return elementToRemove;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getRear() {
		// TODO Auto-generated method stub
		return rear;
	}

	@Override
	public int getFront() {
		// TODO Auto-generated method stub
		return front;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	public void ensureCapacity() {
		if (size + 1 >= capacity) {
			extendCapacity();
		}
	}
	public void extendCapacity() {	
		int newCapacity = capacity * 2;
		T[] newList = (T[]) new Object[capacity * 2];

		for (int i = 0; i < size; i ++) {
			newList[i] = arrayList[(i + front) % capacity];
		}
		arrayList = newList;
		capacity = newCapacity;
		front = 0;
		rear = size - 1;
	}	
	
	
}
