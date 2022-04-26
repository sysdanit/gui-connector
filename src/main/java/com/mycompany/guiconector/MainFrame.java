/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.guiconector;

import java.awt.BorderLayout;

/**
 *
 * @author dani
 */
public class MainFrame extends javax.swing.JFrame {

    protected CanvasScreen canvasScreen;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        setBounds (100, 100, 1280, 768);
        getContentPane ().add (canvasScreen = new CanvasScreen (), BorderLayout.CENTER);
        
        CConnector connector1 = new CConnector (canvasScreen, 20, 20, 40, 40);
        CConnector connector2 = new CConnector (canvasScreen, 120, 20, 40, 40);
        canvasScreen.add (connector1);
        canvasScreen.add (connector2);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        canvasScreen.resizeEvent ();
    }//GEN-LAST:event_formComponentResized



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}