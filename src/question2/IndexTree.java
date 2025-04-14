package question2;

import java.util.ArrayList;

public class IndexTree {
	BinarySearchTree<Word> index;
	
	public IndexTree(String filename) {
		
	}
	
	public void addRecord(String w, int line) {
		
	}
	
	public void printIndex() {
		
	}
	
	private class Word implements Comparable<Word> {
		private String w;
		private int count;
		private ArrayList<Integer> lines;
		
		public Word(String w, int line) {
			
		}
		
		void addOccurrence(int line) {
			
		}
		
		public String toString() {
			return "";
		}
		
		public int compareTo(Word o) {
			return 0;
		}
	}
}
