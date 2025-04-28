package question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IndexTree {
	BinarySearchTree<Word> index = new BinarySearchTree<Word>(); //create BinaryTree used in the IndexTree
	
	public IndexTree(String filename) {
		
		/**Keep track of line Number*/
		int lineNum = 0; 
		/**String to hold next word from Tokenizer*/
		String word;
		/**String to hold next line from Scanner*/
		String nextLine;
		/**File object to pass to Scanner*/
		File file = new File(filename); 
		
		//try to create a scanner (open a file) based on the path
		//if there is no file that matches the path then a catch statement catches exception
		try {
			Scanner sc = new Scanner(file); //open file
			
			//iterate through file line by line
			while(sc.hasNextLine()) {
				nextLine = sc.nextLine(); //set var to next line
				lineNum++; //increment line number
				StringTokenizer token = new StringTokenizer(nextLine); //create StringTokenizer so the line can be separated by word
				//iterate through line by word
				while(token.hasMoreTokens()) {
					word = token.nextToken().replaceAll("[^a-zA-Z]", "").toLowerCase(); //next word
					if (!word.isEmpty()) {
						addRecord(word, lineNum); //add record of word
					}
				}		
			}
			
			sc.close(); //close file
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found, Stack Trace gets Printed: "); //alert user file not found
			e.printStackTrace(); //print stack trace
		}
		
	}
	
	/**
	 * This method adds a word to the index tree if it does not exist, if it does it adds an occurrence.
	 * @param w: the word being examined to see if it should be added to the tree, or a new occurrence should be added
	 * @param line: the line that w was spotted at
	 * @post either the word is added to the tree if it is not in the tree, or if it is in the tree then an occurrence is added.
	 * @return no return
	 */
	
	public void addRecord(String w, int line) {
	    Word word = new Word(w, line); //create new word
	    if(index.contains(word)) { //check if the index has the word already
	        Word existingWord = index.find(word);
	        existingWord.addOccurrence(line); //if so, add an occurrence of the word
	    } else {
	        index.add(word); //if not, add the word to the BinarySearchTree (index)
	    }
	}
	
	
	/**
	 * This method prints the index tree alphabetically with the number of occurrences listed followed by the lines where the word is
	 * @param no param
	 * @post either the word is added to the tree if it is not in the tree, or if it is in the tree then an occurrence is added.
	 * @return no return
	 */
	public void printIndex() {
		index.printOrderedData(); //Will need toString method
	} 
	
	private class Word implements Comparable<Word> {
		//Declaration of Word fields
		private String w;
		private int count;
		private ArrayList<Integer> lines = new ArrayList<Integer>();
		
		public Word(String w, int line) {
			//Setting Word fields
			this.w = w;
			count = 1;
			lines.add(line);
		}
		
		/**
		 * This method checks to see if the occurrence of the word's line is already included in the list. If so, it doesnt get added. If so it does. Increases count regardless
		 * @param line: the line that w was spotted at
		 * @post count increases. line gets added to lines ArrayList if not duplicate, if it is then nothing else happens
		 * @return no return
		 */
		
		public void addOccurrence(int line) {
			boolean duplicateLine = false; //create boolean to hold result of duplicate line
			
			//loops through lines arraylist to check if the line is already included in the list
			for(int i = 0; i < lines.size(); i ++) {
				if(lines.get(i) == line) { //duplicate line found
					duplicateLine = true;
				}
			}
			if(!duplicateLine) { //adds the line if no duplicate line found
				lines.add(line);
			}
			count++; //increment count regardless
		}
		
		/**
		 * This method prints the word and its related fields in the proper format.
		 * @param no param
		 * @post no post, simply return
		 * @return String, word and its fields in proper format
		 */
		public String toString() {
			String toString = w + " (" + count + "): "; //create default string for StringBuilder
			StringBuilder sb = new StringBuilder(toString); //Create StringBuilder

			//loops through lines ArrayList to add the lines to the output
			for(int i = 0; i < lines.size(); i++) {
				sb.append(lines.get(i));
				if(i < lines.size() - 1) { //if not on the last line, add comma. This stops trailing commas and spaces at the end of the output'
					sb.append(", ");
				}
			}
			
			return sb.toString();
		}
		/**
		 * This method lets you compare string to the string field of a word object
		 * @param o: the word you are comparing
=		 * @post no post
		 * @return returns an int which determines if the string is greater than, the same, or less than the word's field.
		 */
		public int compareTo(Word o) {
			int compareWord = w.compareTo(o.w); //compares String to Word.String
			return compareWord;
		}
	}
}
