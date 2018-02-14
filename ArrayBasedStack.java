import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayBasedStack<T> implements StackInterface<T> {
	private T[] data;
	private int topOfStack = -1;
	private static final int INITIAL_CAPACITY = 5;
	private boolean initialized;
	
	@SuppressWarnings("unchecked")
	public ArrayBasedStack(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be a positive integer");
		} else {
			data = (T[]) new Object[capacity];
			initialized = true;
		}
	}
	
	public ArrayBasedStack() {
		this(INITIAL_CAPACITY);
	}
	
	private void expandArray() {
		data = Arrays.copyOf(data, data.length * 2);
		
	}
	
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry) {
		if(topOfStack == data.length - 1) {
			expandArray();
		}
		topOfStack++;
		data[topOfStack] = newEntry;
	}
	
	/** Removes and returns this stack's top entry.
	    @return  The object at the top of the stack. 
	    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T lastItem = data[topOfStack];
		data[topOfStack] = null;
		topOfStack--;
		return lastItem;
	}
	
	/** Retrieves this stack's top entry.
	    @return  The object at the top of the stack.
	    @throws  EmptyStackException if the stack is empty. */
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} 
		return data[topOfStack];
	}
	
	/** Detects whether this stack is empty.
	    @return  True if the stack is empty. */
	public boolean isEmpty() {
		return topOfStack < 0;
	}

	/** Removes all entries from this stack. */
	public void clear() {
		while(!isEmpty()) {
			pop();
		}
	}
}
