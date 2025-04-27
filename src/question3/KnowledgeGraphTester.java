package question3;

public class KnowledgeGraphTester {

	public static void main(String[] args) {
		KnowledgeGraph G = new KnowledgeGraph("whatever.xlsx");
		G.addTriplet("Duplicate", "Test", "Here");
		G.addTriplet("Duplicate", "Test", "Here");
		G.addTriplet("Mickey", "is", "Mouse");
		G.addTriplet("Mickey", "is", "Big");
		G.addTriplet("John", "H.", "Doe");
		G.addTriplet("Sky", "is", "grey");
		
		// Output graph
		System.out.println(G.graph);
		
		//Test function 1
		G.associatedRelation("Sky");
		
		//Test function 2
		G.findEntityPair("is");
		
		//Test function 3
		G.findEntity("Mickey", "is");
	}

}
