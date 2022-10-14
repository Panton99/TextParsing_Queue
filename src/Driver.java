//Jisoo Kim 07/27/2022
//---------------------------------------------------------------------------
//
// Text Parser - with Linked Queue
// This program reads the text and inserts the text into a Linked Queue List
//
// Author: Jisoo Kim
// Date: 07/27/2022
// Class: MET CS342
// Issues: None known
//
// Description:
// Edgar Allan Poe’s The Fall of the House of Usher as text file.
// It is from http://www.gutenberg.org/cache/epub/932/pg932.txt.
// This program counts the entries of the specific words, total entries, the most frequent word and the longest word, 
// and the count of words that occurred more than 20 times.
//
//
// Assumptions:
// The program will count the words in the linked Queue list as follows.
//____________________________________________________________________________

//
// Class: Driver
//
// Description:
// This is the main class that runs the program. 
// It runs the methods in the Queque.class, and MyQueue.class .
//
public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.textParse();
	}
	
	private void textParse() {
		Queue q = new Queue();
		MyQueue qCopy = new Queue();
		MyQueue qCopy2 = new Queue();
		MyQueue qCopy3 = new Queue();
		MyQueue qCopy4 = new Queue();
		MyQueue qCopy5 = new Queue();
		
		//Get text and add into the list and copy the queue list
		q.fillTxt();
		qCopy.fillTxt();
		qCopy2.fillTxt();
		qCopy3.fillTxt();
		qCopy4.fillTxt();
		qCopy5.fillTxt();
		
	
		//Get the input word count 
		System.out.println("Until 'superhuman', removed head count is     : " + qCopy.searchHead("superhuman"));
		System.out.println("Until 'chiromancy', removed head count is     : " + qCopy.searchHead("chiromancy"));
		System.out.println("Until 'unsatisfactory', removed head count is : " + qCopy.searchHead("unsatisfactory"));
		System.out.println("Until 'percutaneous', removed head count is   : " + qCopy.searchHead("percutaneous") + " There is no 'percutaneous' in the text");
		System.out.println("Until 'discernible', removed head count is    "
				+ ": " + qCopy.searchHead("discernible"));
		
		
		//Get the total word count in the text
		System.out.println("How many entries are in the Queue             : " + qCopy.size() + " entries");
		//check first 1000 entries, words that occurred more than 20
		System.out.println("\nIn the first 1000 entries, how many words occur more than 20 times : ");
		System.out.println(qCopy4.check1000());
	
		//Get the most frequent word when removing all the entries
		System.out.println("Most frequent word is        : "+ "'" + qCopy2.findMostFreq().getWord() + "'" + ", Count is " + q.findMostFreq().getCount());
		//Get the longest word when removing all the entries
		System.out.println("Longest word is              : " + "'" + qCopy3.maxLength() + "'");

	}

}
