//Jisoo Kim 07/27/2022
//
// Class: Node
//
// Description:
// Node class has mutators and accessors for linked Queue list. 
// This class is used in Queue.class.
//
public class Node {
	private String word;
	private int count;
	private Node next;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
