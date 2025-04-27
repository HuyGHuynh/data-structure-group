package question3;

public class KnowledgeGraphTester {

	public static void main(String[] args) {
		KnowledgeGraph G = new KnowledgeGraph("Sample-dataset-project.2025.xlsx");
		
		// Output graph
		System.out.println(G.graph);
		
		//Test function 1
		G.associatedRelation("Monoclonal Antibodies");
		
		//Test function 2
		System.out.println("---------");
		G.findEntityPair("PREVENTS");
		
		//Test function 3
		System.out.println("---------");
		G.findEntity("Pathologic Processes", "COEXISTS_WITH");
	}

}
