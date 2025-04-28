package question3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class KnowledgeGraphGUI {
    private KnowledgeGraph kg;
    private JFrame frame;
    private JTextField entityField;
    private JTextField relationField;
    private JTextArea outputArea;

    public KnowledgeGraphGUI(KnowledgeGraph kg) {
        this.kg = kg;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Knowledge Graph Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns

        entityField = new JTextField(20);
        relationField = new JTextField(20);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Query by Entity");
        JButton button2 = new JButton("Query by Relation");
        JButton button3 = new JButton("Query by Entity + Relation");

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        topPanel.add(new JLabel("Entity:"));
        topPanel.add(entityField);
        topPanel.add(new JLabel("Relation:"));
        topPanel.add(relationField);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);


        // Button 1: Query by Entity
        button1.addActionListener(new ActionListener() {
            @Override	
            public void actionPerformed(ActionEvent e) {
                String entityInput = entityField.getText().trim();
                outputArea.setText("");

                if (!entityInput.isEmpty()) {
                    outputArea.append("Result for Entity: " + entityInput + "\n");

                    KnowledgeGraph subGraph = kg.associatedRelation(entityInput);

                    if (subGraph != null) {
                        subGraph.exportFullGraph("mini.dot", "mini.svg");
                        openGraphImage("mini.svg");
                    } else {
                        outputArea.append("Entity not found.\n");
                    }
                } else {
                    outputArea.append("Please enter an Entity.\n");
                }
            }
        });


        // Button 2: Query by Relation
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String relationInput = relationField.getText().trim();
                outputArea.setText("");

                if (!relationInput.isEmpty()) {
                    outputArea.append("Result for Relation: " + relationInput + "\n");

                    KnowledgeGraph subGraph = kg.findEntityPair(relationInput);

                    if (subGraph != null) {
                    	subGraph.exportFullGraph("mini.dot", "mini.svg");
                        openGraphImage("mini.svg");
                    } else {
                        outputArea.append("Relation not found.\n");
                    }
                } else {
                    outputArea.append("Please enter a Relation.\n");
                }
            }
        });


        // Button 3: Query by Entity + Relation
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entityInput = entityField.getText().trim();
                String relationInput = relationField.getText().trim();
                outputArea.setText("");

                if (!entityInput.isEmpty() && !relationInput.isEmpty()) {
                    outputArea.append("Result for Entity: " + entityInput + ", Relation: " + relationInput + "\n");

                    KnowledgeGraph subGraph = kg.findEntity(entityInput, relationInput);

                    if (subGraph != null) {
                    	subGraph.exportFullGraph("mini.dot", "mini.svg");
                        openGraphImage("mini.svg");
                    } else {
                        outputArea.append("No match found.\n");
                    }
                } else {
                    outputArea.append("Please enter both Entity and Relation.\n");
                }
            }
        });


        frame.setVisible(true);
    }
    
    private void openGraphImage(String imagePath) {
        try {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                Desktop.getDesktop().open(imageFile);
            } else {
                System.out.println("Image file not found: " + imagePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
