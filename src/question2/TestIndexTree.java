package question2;

public class TestIndexTree {
	
	public static void main(String[] args) {
	
		//Test Index with valid input file
		System.out.println("Valid Index:");
		IndexTree index = new IndexTree("input.txt");
		index.printIndex();
		
		System.out.println("\n\n");
		
		//Test Index with blank input file
		System.out.println("Blank Index: ");
		IndexTree blankIndex = new IndexTree("blank.txt");
		blankIndex.printIndex();
		
		System.out.println("\n\n");
		
		//Test Index with non existent file
		System.out.println("Non Existant File: ");
		IndexTree noFileIndex = new IndexTree("ThisFileDoesNotExist.txt");
		noFileIndex.printIndex();
		
	}	
}
