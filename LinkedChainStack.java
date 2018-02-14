import java.util.EmptyStackException;

 public class LinkedChainStack<E> implements StackInterface<E> {
	 private Node<E> topNode;
	
	 public void push(E newElement) {
		 Node newNode = new Node(newElement);
		 newNode.setNext(topNode);
		 topNode = newNode;
	 }
	
	 public boolean isEmpty() {
	 	return topNode == null;
	 }
	
	 public E pop() {
	 // throw an exception if stack is empty
	 // store data from current top node (type E)
	 // set the top node to reference the next node in the stack
	 // return the stored data
		 if (isEmpty()) {
			 throw new EmptyStackException();
		 }
		 E currentVal = topNode.getValue();
		 topNode = topNode.getNext();
		 return currentVal;
	 }
	
	 public E peek() {
	 // throw an exception if stack is empty
	 // return the data from the top node
		 if (isEmpty()) {
			 throw new EmptyStackException();
		 }
		 return topNode.getValue();
	 }
	 
	 public void clear() {
		 topNode = null;
	 }
	 
	 private class Node<E> {
		 private Node<E> nextNode;
		 private E value;
		 
		 public Node(E val) {
			 nextNode = null;
			 value = val;
		 }
		 
		 public Node(E val, Node next) {
			 nextNode = next;
			 value = val;
		 }
		 
		 public void setNext(Node next) {
			 nextNode = next;
		 }
		 
		 public Node getNext() {
			 return nextNode;
		 }
		 
		 public void setValue(E val) {
			 value = val;
		 }
		 
		 public E getValue() {
			 return value;
		 }
	 }
 }
