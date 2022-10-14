
import edu.bu.met.cs342.TextParser; //Import the text parsing methods

//Jisoo Kim 07/27/2022

//
//Class: Queue
//
//Description:
//Queue class have methods about linked queue list and text parsing.
//This class implements MyQueue.class.
//
public class Queue implements MyQueue {
	TextParser t = new TextParser();
	
	private Node head;
	private Node tail;
	private int count;
	private int cntHead;
	private String word;
	private String []arr;
	
	
	/* fillTxt() (to fill the text into the linked queue list)
	 * input : text file
	 * output : String array in to the linked queue list
	 * return : none
	 * */
	public void fillTxt() {
		t.openFile("pg932.txt");
			
		while ((word = t.getNextWord()) != null) {		
				arr = isAlphaNumeric(word).split(" "); //remove non-alphanumeric words and make it into String array
				addMany(arr); //add the String []arr into the linked list
		}
	}
	
	/* addMany() (is to add String []arr)
	 * input : Strings []arr
	 * output : String array in the queue
	 * */
	public void addMany(String... other) {
		for (String d : other) {
			add(d); //add the string []arr	
		}

	}
	
	/* isAlphaNumeric() (find the non-alphanumeric char)
	 * input : word
	 * output : string word (lower case & non-alphanumeric char is removed)
	 * return : string word
	 * */
	public String isAlphaNumeric(String word) {
		String tmp = "";
		
		for(int i = 0; i < word.length(); i++) {
			 char x = word.charAt(i);
			 int ascii = (int)x;
			 
			 //ascii that are a-z, A-Z, 0-9, space (otherwise it is not put into the string)
			 if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57) || (ascii == 32) ) {
				 tmp += word.charAt(i); 
			 }
		 }
		return tmp.toLowerCase();
		
	}
	
	/* add() (add the word in the linked queue)
	 * input : word
	 * output : none
	 * return : true if the word is set in the tail
	 * */
	public boolean add(String word) {
		Node newNode = new Node();
		int cnt = 0;
		
		newNode.setWord(word);
		if (isEmpty()) {
			count = 1;
			head = tail = newNode;
			return true;
		}
		
		tail.setNext(newNode);
		count++;
		tail = newNode;
		return true;
	}
	
	/* remove()  (remove head node in the linked queue)
	 * input : 
	 * output : none
	 * return : return the deleted node
	 * */
	public String remove() {
		
		if (isEmpty()) {
			return null;
		}
		String tmp = head.getWord();
		head = head.getNext();
		count--;
		cntHead++;
		
		if (count == 0) {
			head = tail = null;
			
		}
		return tmp;
	}
	
	/* searchHead() (search the head count until the word)
	 * input : word
	 * output : head count
	 * return : true if there is a equal word in the linked queue
	 * */
	public int searchHead(String word) {
		Node t = head;
		int wCnt = 1;
		
		while (t != null) {
			wCnt++;
			if (t.getWord().equals(word)) {
				wCnt--;
				break;
			}
			t = t.getNext();
		}
		return wCnt;
	}
	
	/* search() (search the word count)
	 * input : word
	 * output : head count
	 * return : true if there is a equal word in the linked queue
	 * */
	public int search(String word) {
		Node t = head;
		int wCnt = 1;
		
		while (t != null) {
			if (t.getWord().equals(word)) {
				wCnt++;
			}
			t = t.getNext();
		}
		return wCnt;
	}
	
	/* isEmpty() (check the linked queue is empty)
	 * input : 
	 * output : none 
	 * return : return count
	 * */
	public boolean isEmpty() {
		return (count == 0) ;
	}
	
	/* size()  (check the size of the linked queue list)
	 * input : 
	 * output : count 
	 * return : return the count
	 * */	
	public int size() {
		return count + 1;
	}
	
	/* search1000() (search the word count)
	 * input : word
	 * output : head count
	 * return : true if there is a equal word in the linked queue
	 * */
	public int search1000(String word) {
		Node t = head;
		int wCnt = 1;
		int counter = 0;
		
		while (counter < 1000) {
			if (t.getWord().equals(word)) {
				wCnt++;
			}
			t = t.getNext();
			counter++;
		}
		return wCnt;
	}

	/* check1000()  (remove the 1000 head, and count the word that occurred more than 20)
	 * input : removed head
	 * output : none
	 * return : cnt
	 * */	
	public String check1000() {
		Node n = new Node();
		String str = "";
		int tmp = 0;
		String maxTmp = "";
		Node h = head;
		
		int cnt = 0;
	
		
		while (cntHead < 1000) { //remove for 1000 times
			maxTmp = remove();  //remove the head
				
			//search and count the word
			n.setCount(search1000(maxTmp));
			n.setWord(maxTmp);
			n.setNext(h);
			h = n;
			
			
			
			if (n.getCount() > 20) { //if the count is more than 20	
				deleteDuplicate();
				str += "'"+ n.getWord() +"' occured " + n.getCount() +" times, ";
			}
			
		}
		return str;
	}
	
	/* deleteDuplicate() (to find the duplicate of each word in the list, and delete the duplicates)
	 * input : nodes
	 * output : duplicate nodes are deleted
	 * */
	public void deleteDuplicate() {
		Node cur = head;
		Node next = null;
		Node tmp = null;
		int counter = 0;
		
		if(head == null) {
			return;
		} else {	
		while (counter < 1000) {
				tmp = cur;
				next = cur.getNext();
				counter++;
				while (next != null) {
					//If the current and next is equal, delete the next
					if (cur.getWord().equals(next.getWord())) {
						tmp.setNext(next.getNext());
			
					} else {//If the words are not equal
						tmp = next;
					}
					next = next.getNext();
				}
				cur = cur.getNext();
			}
		}
	}
	
	/* findMostFreq()  (find the most nodes in the linked queue list)
	 * input : node
	 * output : word (most frequent word)
	 * return : true if the word count is max in the linked queue list
	 * */	
	public Node findMostFreq() {
		Node n = new Node();
		int max = 0;
		String str = "";
		int tmp = 0;
		String maxTmp = "";
		
		while ((maxTmp = remove()) != null) { //Until the Queue is not empty
			  //remove the head
			tmp = search(maxTmp); //search the word and count when maxTmp word is occurred
			
			if (tmp > max) { //if the count is more than max, it is a max
				max = tmp;	//set max count to tmp
				str = maxTmp; //max frequency word is str
				n.setWord(str);
				n.setCount(max);
			}
		}
		return n;
	}
	
	
	/* maxLength()  (find the longest word in the list)
	 * input : node
	 * output : word (max length)
	 * return : true if the word length is max in the list
	 * */	
	public String maxLength() {
		String max = "";
		String h = "";
		
		while ((h = remove()) != null) {
			if (h.length() >= max.length()) { //the length of the word is longer than max, it is a max
				max = h;	
			}
		}
		return max;
	}
	

}
