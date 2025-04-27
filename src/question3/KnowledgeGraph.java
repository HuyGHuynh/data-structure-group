package question3;

import java.util.LinkedList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class KnowledgeGraph {
	BinarySearchTree<EntityNode> graph;
	
	public KnowledgeGraph(String filename) {
		//convert .xlsx file to graph data (later on)
		graph = new BinarySearchTree<>();
		
		//read Excel file input
        try (FileInputStream fis = new FileInputStream(filename);
                Workbook workbook = new XSSFWorkbook(fis)) {

               Sheet sheet = workbook.getSheetAt(0); // Read first sheet
               for (Row row : sheet) {
                   // Skip empty or header rows if needed
                   if (row.getRowNum() == 0) continue;  // Skip first row if it's a header

                   Cell cellEntity1 = row.getCell(1);
                   Cell cellRelation = row.getCell(2);
                   Cell cellEntity2 = row.getCell(4);

                   if (cellEntity1 != null && cellRelation != null && cellEntity2 != null) {
                       String entity1 = cellEntity1.toString().trim();
                       String relation = cellRelation.toString().trim();
                       String entity2 = cellEntity2.toString().trim();

                       addTriplet(entity1, relation, entity2);
                   }
               }
           } catch (IOException e) {
               System.out.println("Error reading Excel file: " + e.getMessage());
           }
	}
	
	public void addTriplet(String entity1, String relation, String entity2) {
		// If entity1 does not exist in graph, add node to graph
		EntityNode node = new EntityNode(entity1);
		if(!graph.contains(node)) {
			graph.add(node);
		}
		// Get reference node to modify and append new edges
		EntityNode refNode = graph.find(node);
		
		//Check if edges is already exist
		boolean duplicate = false;
		for(RelationEdge edge : refNode.edges) {
			if(edge.relation.equals(relation) && edge.entity2.equals(entity2)) {
				duplicate = true;
				break;
			}
		}
		
		// Add edge if not duplicated
		if(!duplicate) {
			refNode.edges.add(new RelationEdge(relation, entity2));
		}
	}
	
	public void associatedRelation(String entity1) {
		EntityNode node = new EntityNode(entity1);
		// Get reference node for queries
		EntityNode refNode = graph.find(node);
		if(refNode != null) {
			System.out.println(refNode.entity1 + " relations:");
			for(RelationEdge edge : refNode.edges) {
				String relation = edge.relation;
				String entity2 = edge.entity2;
				System.out.println(relation + " -> " + entity2);
			}
		} else {
			System.out.println("Entity not found");
		}
	}
	
	public void findEntityPair(String relation) {
		findEntityPair(graph.root, relation);
	}
	
	private void findEntityPair(BinaryTree.Node<EntityNode> localRoot, String relation) {
		//Perform inorder traversal
		//At each EntityNode visit, find matching "relation" in "edges" linked list
		
		//Base case
		if(localRoot == null) {
			return;
		}
		
		findEntityPair(localRoot.left, relation);
		
		EntityNode currentNode = localRoot.data;
		for(RelationEdge edge : currentNode.edges) {
			if(edge.relation.equals(relation)) {
				String entity1 = currentNode.entity1;
				String entity2 = edge.entity2;
				System.out.println(entity1 + " -> " + relation + " -> " + entity2);
			}
		}
		
		findEntityPair(localRoot.right, relation);
		
	}
	
	public void findEntity(String entity1, String relation) {
		EntityNode node = new EntityNode(entity1);
		// Get reference node for queries
		EntityNode refNode = graph.find(node);
		if(refNode != null) {
			boolean found = false;
			for(RelationEdge edge : refNode.edges) {
				if(edge.relation.equals(relation)) {
					String entity2 = edge.entity2;
					System.out.println(entity1 + " -> " + relation + " -> " + entity2);
					found = true;
				}
				
			}
			if(!found) {
				System.out.println("Relation not found");
			}
		} else {
			System.out.println("Entity not found");
		}
	}
	
	private class EntityNode implements Comparable<EntityNode>{
		String entity1;
		List<RelationEdge> edges = new LinkedList<>();
		
		public EntityNode(String entity1) {
			this.entity1 = entity1;
		}
		
		@Override
		public int compareTo(EntityNode o) {
			return this.entity1.compareTo(o.entity1);
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(entity1+ ": ");
			for(RelationEdge edge: edges) {
				String relation = edge.relation;
				String entity2 = edge.entity2;
				sb.append(relation + " -> " + entity2 + ", ");
			}
			
			if (!edges.isEmpty()) {
		        sb.setLength(sb.length() - 2); // remove last "," and final whitespace, which is 2 characters
		    }
			
			return sb.toString();
		}
	}
	
	private class RelationEdge {
		String relation;
		String entity2;
		
		public RelationEdge(String relation, String entity2) {
			this.relation = relation;
			this.entity2 = entity2;
		}
	}
}	
