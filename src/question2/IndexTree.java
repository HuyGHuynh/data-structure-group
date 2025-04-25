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
			this.w = w;
			count = 1;
			lines.add(line);
		}
		
		void addOccurrence(int line) {
			boolean duplicateLine = false;
			for(int i = 0; i < lines.size(); i ++) {
				if(lines.get(i) == line) {
					duplicateLine = true;
				}
			}
			if(!duplicateLine) {
				lines.add(line);
			}
			count++;
		}
		
		public String toString() {
			String toString = w + " (" + count + "): ";
			StringBuilder sb = new StringBuilder(toString);

			for(int i = 0; i < lines.size(); i++) {
				sb.append(lines.get(i));
				if(i < lines.size() - 1) {
					sb.append(", ");
				}
			}
			
			return toString;
		}
		
		public int compareTo(Word o) {
			int compareWord = w.compareTo(o.w);
			return compareWord;
		}
	}
}
