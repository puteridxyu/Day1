package lesson9.assignment.q6;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileExplorer extends JFrame {

    private JTree fileTree;
    private DefaultMutableTreeNode rootNode;
    private JTextArea fileInfoArea;

    public FileExplorer() {
        setTitle("File Explorer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        rootNode = new DefaultMutableTreeNode(new FileNode(new File("C:/"))); // Root directory
        fileTree = new JTree(rootNode);
        fileTree.setRootVisible(false);
        fileTree.expandRow(0);

        fileInfoArea = new JTextArea(20, 40);
        fileInfoArea.setEditable(false);

        JScrollPane treeScrollPane = new JScrollPane(fileTree);
        JScrollPane infoScrollPane = new JScrollPane(fileInfoArea);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, infoScrollPane);
        splitPane.setDividerLocation(200);

        add(splitPane);
        setListeners();
        setVisible(true);
    }

    private void setListeners() {
        fileTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.getUserObject() instanceof FileNode) {
                FileNode fileNode = (FileNode) selectedNode.getUserObject();
                displayFileInfo(fileNode.getFile());
            }
        });
    }

    private void displayFileInfo(File file) {
        if (file.isDirectory()) {
            fileInfoArea.setText("Directory: " + file.getAbsolutePath() + "\n\nContents:\n");

            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    fileInfoArea.append(f.getName() + "\n");
                }
            }
        } else {
            fileInfoArea.setText("File: " + file.getAbsolutePath() + "\n\nSize: " + file.length() + " bytes");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileExplorer::new);
    }

    private class FileNode {
        private File file;

        public FileNode(File file) {
            this.file = file;
        }

        public File getFile() {
            return file;
        }

        @Override
        public String toString() {
            return file.getName();
        }
    }
}
