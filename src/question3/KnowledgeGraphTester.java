package question3;

public class KnowledgeGraphTester {

	public static void main(String[] args) {
		KnowledgeGraph G = new KnowledgeGraph("Sample-dataset-project.2025.xlsx");
		KnowledgeGraphGUI gui = new KnowledgeGraphGUI(G);
	}

}
