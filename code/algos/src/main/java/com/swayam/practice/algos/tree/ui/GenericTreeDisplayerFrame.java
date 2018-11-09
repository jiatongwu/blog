/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swayam.practice.algos.tree.ui;

import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swayam.practice.algos.tree.BinarySearchTree;
import com.swayam.practice.algos.tree.GenericTree;

/**
 *
 * @author paawak
 */
public class GenericTreeDisplayerFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericTreeDisplayerFrame.class);

    private final GenericTree<Integer> tree;

    /**
     * Creates new form TreeDisplayer
     */
    public GenericTreeDisplayerFrame(GenericTree<Integer> tree) {
        this.tree = tree;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        scrPnTree = new javax.swing.JScrollPane();
        jTree = new JTree(new DefaultTreeModel(tree.getElementsAsTreeNode()));
        pnlBottom = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTitle.setLayout(new java.awt.BorderLayout());

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Tree Demo");
        pnlTitle.add(lbTitle, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlTitle, java.awt.BorderLayout.PAGE_START);

        scrPnTree.setViewportView(jTree);

        getContentPane().add(scrPnTree, java.awt.BorderLayout.CENTER);

        pnlBottom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdd.setText("add node ...");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlBottom.add(btnAdd);

        btnRemove.setText("remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        pnlBottom.add(btnRemove);

        getContentPane().add(pnlBottom, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed

        Optional<Integer> input = getUserInputForInteger("Enter the number to add", "Add");

        if (input.isPresent()) {
            Integer inputInt = input.get();

            LOGGER.info("Trying to add element {}...", inputInt);
            tree.add(inputInt);
            jTree.setModel(new DefaultTreeModel(tree.getElementsAsTreeNode()));
        }

    }// GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRemoveActionPerformed
        if (tree.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cannot remove element as the tree is empty", "Tree is empty",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (tree instanceof BinarySearchTree) {

            Optional<Integer> input = getUserInputForInteger("Enter the number to remove", "Remove");

            if (input.isPresent()) {
                Integer inputInt = input.get();

                LOGGER.info("Trying to remove element {}...", inputInt);

                ((BinarySearchTree<Integer>) tree).remove(inputInt);
            }

        } else {
            tree.remove();
        }

        jTree.setModel(new DefaultTreeModel(tree.getElementsAsTreeNode()));
    }// GEN-LAST:event_btnRemoveActionPerformed

    private Optional<Integer> getUserInputForInteger(String message, String title) {
        String input = JOptionPane.showInputDialog(this, message, title,
                JOptionPane.INFORMATION_MESSAGE);

        try {
            Integer inputAsInt = Integer.valueOf(input);
            return Optional.of(inputAsInt);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid number", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return Optional.empty();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrPnTree;
    // End of variables declaration//GEN-END:variables
}
