//Jisoo Kim 07/27/2022

//
//Class: MyQueue
//
//Description:
//MyQueue class is an interface to implement in Queue.class.
//This class would allow the copy of the queue list in the Driver.class.s
//
public interface MyQueue {

	/* fillTxt() (to fill the text into the linked Queue list)
	 * input : text file
	 * output : String array in to the linked list
	 * return : none
	 * */
	void fillTxt();

	/* addMany()    (is to add String []arr)
	 * input : Strings []arr
	 * output : String array in the queue
	 * */
	void addMany(String... other);

	/* isAlphaNumeric()   (find the non-alphanumeric char)
	 * input : word
	 * output : string word (lower case & non-alphanumeric char is removed)
	 * return : string word
	 * */
	String isAlphaNumeric(String word);

	/* add()  (add the word in the linked queue)
	 * input : word
	 * output : none
	 * return : true if the word is set in the tail
	 * */
	boolean add(String word);
	
	/* remove()   (remove head node in the linked queue)
	 * input : 
	 * output : none
	 * return : return the deleted node
	 * */
	String remove();

	/* searchHead()  (search the head count until the word)
	 * input : word
	 * output : head count
	 * return : true if there is a equal word in the linked queue
	 * */
	int searchHead(String word);

	/* isEmpty() (check the linked queue is empty)
	 * input : 
	 * output : none 
	 * return : return count
	 * */
	boolean isEmpty();
	
	/* size()  (check the size of the linked queue list)
	 * input : 
	 * output : count 
	 * return : return the count
	 * */	
	int size();

	/* findMostFreq()  (find the most nodes in the linked queue list)
	 * input : node
	 * output : word (most frequent word)
	 * return : true if the word count is max in the linked queue list
	 * */
	Node findMostFreq();
	
	/* check1000()  (remove the 1000 head, and count the word that occurred more than 20)
	 * input : removed head
	 * output : none
	 * return : cnt
	 * */	
	public String check1000();

	/* maxLength()  (find the longest word in the list)
	 * input : node
	 * output : word (max length)
	 * return : true if the word length is max in the list
	 * */	
	public String maxLength();
	
	/* search1000() (search the word count)
	 * input : word
	 * output : head count
	 * return : true if there is a equal word in the linked queue
	 * */
	public int search1000(String word);
	
	/* deleteDuplicate() (to find the duplicate of each word in the list, and delete the duplicates)
	 * input : nodes
	 * output : duplicate nodes are deleted
	 * */
	public void deleteDuplicate();
	
	

}